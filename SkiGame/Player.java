import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private ArrayList<Actor> hits;
    
    private GreenfootImage normal;
    private GreenfootImage down;
    private GreenfootImage jump;
    private GreenfootImage hit;

    /**
     * Constructor
     */
    public Player(double start)
    {
        setRotation(10);
        normal = new GreenfootImage("skiernormal.png");
        down = new GreenfootImage("skierducking.png");
        jump = new GreenfootImage("skierjumping.png");
        hit = new GreenfootImage("skierhit.png");
        hits = new ArrayList<Actor>();
        startingY = start;
        setImage(normal);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkGravity();
        checkCollision();
        
        if(Greenfoot.isKeyDown("up") && objectIsBelow()) //jumping key
        {
           setImage(jump);
            jump();
        }
        else if (Greenfoot.isKeyDown("space") && objectIsBelow())
        {
            jump();
            setImage(jump);
        }
        
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("shift"))// animation for skier to duck
        { 
            setImage(down);   
        }
        else 
        {
            setImage(normal);  
        }
    }    

    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    private void fall()
    {
        setLocation(getExactX(), getExactY() + ySpeed);
        if (getExactY() > startingY && isAlive)
        {
            setLocation(getExactX(), startingY);
        }
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
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Actor.class) != null)
        {
            return true;
        }
        else if (getY() >= getWorld().getHeight() - getImage().getHeight() + 400)
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
        setLocation(getX(), getY() + ySpeed); //leave ground
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
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        if(obstacle != null)
        {
            if(!alreadyHit(obstacle))
            {
                hits.add(obstacle);
            }
            
            if(hits.size() >= 3)
            {
                isAlive = false;
                SkiWorld w = (SkiWorld) getWorld();
                w.setIsAlive(isAlive);
                setImage(hit);
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
}
