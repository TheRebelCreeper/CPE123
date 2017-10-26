import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @Tony Bone, Ritu Bhalodia, Elena Fowler, Aaron Lampert, Jarod Morris
 * @Beta 0.1
 */
public class Player extends SmoothMover
{
    private final double GRAVITY_ACCEL = 1.5;
    private final double MAX_GRAV = 10.0;
    private double ySpeed = 0;
    private double startingY;
    private boolean isAlive = true;
    private ArrayList<Actor> hits = new ArrayList<Actor>();
    private boolean didGetHit = false;
    
    private boolean upPressed;
    private boolean downPressed;
    private boolean spacePressed;
    private boolean shiftPressed;
    
    private int delay;
    private static final int DELAY = 5;
    
    private GreenfootImage normal;
    private GreenfootImage down;
    private GreenfootImage jump;
    private GreenfootImage hit;

    private PlayerHitbox hitbox;
    
    /**
     * Constructor
     */
    public Player()
    {
        setRotation(10);
        normal = new GreenfootImage("skiernormal.png");
        down = new GreenfootImage("skierducking.png");
        jump = new GreenfootImage("skierjumping.png");
        hit = new GreenfootImage("skierhit.png");
        setImage(normal);
        delay = DELAY;
    }
    
    protected void addedToWorld(World w)
    {
        startingY = getY() + 5;
        hitbox = new PlayerHitbox(this, 55, 95, -7, -3, true); // Set to false for invisible hitbox
        getWorld().addObject(hitbox, getX(), getY());
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        upPressed = Greenfoot.isKeyDown("up");
        downPressed = Greenfoot.isKeyDown("down");
        shiftPressed = Greenfoot.isKeyDown("shift");
        spacePressed = Greenfoot.isKeyDown("space");
        
        checkGravity();
        checkCollision();
        checkJump();
        
        if (downPressed || shiftPressed)// animation for skier to duck
        { 
            setImage(down); 
            hitbox.crouchHitbox();
        }
        else if (upPressed || spacePressed)
        {
           setImage(jump);
           hitbox.jumpHitbox();
        }
        else if( /*hits.size()  < 3 && */ didGetHit == false)
        {
            setImage(normal); 
            hitbox.normalHitbox();
        }
        
        if (getExactY() > startingY && isAlive && !(shiftPressed || downPressed))
        {
            setLocation(getExactX(), startingY);
        }
        
        if(didGetHit == true)
        {
            setImage(hit);
            delayImage();
        }
    }    

    private void checkJump()
    {
        if(upPressed && objectIsBelow()) //jumping key
        {
           jump();
        }
        else if (spacePressed && objectIsBelow())
        {
            jump();
        }
    }
    
    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    private void fall()
    {
        setLocation(getExactX(), getExactY() + ySpeed);

        if( ySpeed <= MAX_GRAV)   // Terminal Velocity
        {
            ySpeed += GRAVITY_ACCEL;
        }
    }

    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @return Returns true if there is an object at the coordinates passed in
     */
    private boolean objectIsBelow()
    {
        List<Actor> list = hitbox.getHitboxIntersectionsAtOffset(0, hitbox.getImage().getHeight() / 2 + 5, Actor.class);
        if (list.size() > 0 && !(list.get(0) instanceof Player))
        {
            System.out.println(list.get(0));
            return true;
        }
        else if (hitbox.getY() >= getWorld().getHeight() - getImage().getHeight() + 400)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Allows the player to jump
     */
    private void jump()
    {
        ySpeed = -20.00; //add jump speed?
        setLocation(getExactX(), getExactY() + ySpeed); //leave ground
    }
    
    /**
     * Determines if the player should fall or not
     */
    private void checkGravity()
    {
        if (objectIsBelow() && isAlive)    // If object is on solid ground
        {
            ySpeed = 0.0;
        }
        else
        {
            fall();
        }
    }
    
    public void checkCollision()
    {
        Actor obstacle = hitbox.getOneIntersectingObjectPublic(Obstacle.class);
        if(obstacle != null)
        {
            setImage(hit);
            if(!alreadyHit(obstacle))
            {
                hits.add(obstacle);
                //System.out.println("Hit " + hits.size());
                didGetHit = true;
                
                
            }
            
            if(hits.size() >= 3)
            {
                this.setImage(hit);
                isAlive = false;
                SkiWorld w = (SkiWorld) getWorld();
                w.setIsAlive(isAlive);
                //setImage(hit);
            }
        }
    }
    
    public boolean alreadyHit(Actor o)
    {
        boolean hit = false;
        for(int i = 0; i < hits.size(); i++)
        {
            if(o == hits.get(i))
            {
                hit = true;
            }
        }
        return hit;
    }
    
    private void delayImage()
    {
        delay--;
        if(delay <= 0)
        {
            didGetHit = false;
            delay = DELAY;
        }
    }
}
