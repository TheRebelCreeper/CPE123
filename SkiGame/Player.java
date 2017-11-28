import greenfoot.*;
import java.util.ArrayList;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @Tony Bone, Ritu Bhalodia, Elena Fowler, Aaron Lampert, Jarod Morris
 * @Beta 0.1
 */
public class Player extends SmoothMover implements Gravity
{
    /**Vertical Velocity*/
    private double ySpeed = 0;
    /**Initial Y position*/
    private double startingY;
    /**Boolean holding status of life*/ //Reword this?
    private boolean isAlive = true;
    /**Explain what this does please whoever added it*/
    private ArrayList<Actor> hits = new ArrayList<Actor>();
    /**Boolean holding status of if the Player got hit*/
    private boolean didGetHit = false;
    
    /**Boolean holding status of the UP key*/
    private boolean upPressed;
    /**Boolean holding status of the DOWN key*/
    private boolean downPressed;
    /**Boolean holding status of the SPACE key*/
    private boolean spacePressed;
    /**Boolean holding status of the SHIFT key*/
    private boolean shiftPressed;
    /**Needs comment explaining*/
    private int delay;
    /**Needs comment explaining*/
    private static final int DELAY = 6;
    /**Player's hitbox*/
    private PlayerHitbox hitbox;
    
    /**Image of the player normally*/
    private GreenfootImage normal;
    /**Image of the player crouching*/
    private GreenfootImage down;
    /**Image of the player jumping*/
    private GreenfootImage jump;
    /**Image of the player taking damage*/
    private GreenfootImage hit;
    
    /**Images for snow animation*/
    private GreenfootImage normal1;
    private GreenfootImage normal2;
    private GreenfootImage normal3;
    private GreenfootImage normal4;
    
    private GreenfootImage ducking1;
    private GreenfootImage ducking2;
    private GreenfootImage ducking3;
    private GreenfootImage ducking4;
    
    private int frame;
    
    private GreenfootSound gettinghit;
    private GreenfootSound die;
    
    boolean touchingMaterial1 =false;
    boolean touchingpowerup =false;
    
    public ArrayList<Power> totalp = new ArrayList<Power>();
    public ArrayList<Shield> totals = new ArrayList<Shield>();
    
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
        
        normal1 = new GreenfootImage("skiernormal1.png");
        normal2 = new GreenfootImage("skiernormal2.png");
        normal3 = new GreenfootImage("skiernormal3.png");
        normal4 = new GreenfootImage("skiernormal4.png");
        ducking1 = new GreenfootImage("skierduckingsnow1.png");
        ducking2 = new GreenfootImage("skierduckingsnow2.png");
        ducking3 = new GreenfootImage("skierduckingsnow3.png");
        ducking4 = new GreenfootImage("skierduckingsnow4.png");
        gettinghit = new GreenfootSound("sounds/gettinghit.mp3");  
        die = new GreenfootSound("sounds/die.mp3");
        
        setImage(normal);
        
        
        delay = DELAY;
    }
    
    /**
     * Called when the Player is added to the world
     */
    protected void addedToWorld(World w)
    {
        startingY = getY() + 5; // Starting position of the player + 5
        hitbox = new PlayerHitbox(this, 55, 95, -7, -3, false); // Set to false for invisible hitbox
        getWorld().addObject(hitbox, getX(), getY());   // Adds the hitbox to the world
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        upPressed = Greenfoot.isKeyDown("up");          // Gets status of the UP key
        downPressed = Greenfoot.isKeyDown("down");      // Gets status of the DOWN key
        shiftPressed = Greenfoot.isKeyDown("shift");    // Gets status of the SHIFT key
        spacePressed = Greenfoot.isKeyDown("space");    // Gets status of the SPACE key
        
        checkGravity();     // Checks the gravity 
        checkCollision();   // Checks for collisions
        checkJump();        // Checks if the player should jump
        checkForMaterials();
        checkForPower();// Checks for collisions with Material1
        checkForLedge();
        
        if (downPressed || shiftPressed)    // animation for skier to duck
        { 
            animatesnowducking();         // Changes image for the skier
            hitbox.crouchHitbox();  // Changes hitbox for the skier
        }
        else if (upPressed || spacePressed) // animation for the skier to jump
        {
           setImage(jump);          // Changes image for the skier
           hitbox.jumpHitbox();     // Changes hitbox for the skier
        }
        else if(isAlive && !didGetHit)      // normal animation for the skier
        {
            animatesnow();
            //setImage(normal);       // Changes image for the skier
            hitbox.normalHitbox();  // Changes hitbox for the skier
        }
        
        // If the player is below the startingY, is alive, and not crouched
        if (getExactY() > startingY && isAlive && !(shiftPressed || downPressed))
        {
            setLocation(getExactX(), startingY);
        }
        
        // If the player got hit
        if(didGetHit)
        {
            gettinghit.play();
            setImage(hit);
            delayImage();
        }
        
        if(getY() > getWorld().getHeight() + 30)
        {
            SkiWorldOver s = new SkiWorldOver();
            Greenfoot.setWorld(s);
        }
        
        SkiWorld a = (SkiWorld)getWorld();
        if( a.getLodgeDelay() > 1800 )
        {
            move(5);
            endLevel();
        }
        
    }
    
    public void animatesnow(){ 
        frame++;
        if (frame==1)
        {
            setImage(normal1);
        }
        else if(frame==2)
        {
            setImage(normal2);
        }
        else if(frame==3)
        {
            setImage(normal3);
        }
        else if (frame==4)
        {
            setImage(normal4);
            frame = 1;
            return;
        }

    }
    
    public void animatesnowducking() {
        
        frame++;
        if (frame==1)
        {
            setImage(ducking1);
        }
        else if(frame==2)
        {
            setImage(ducking2);
        }
        else if(frame==3)
        {
            setImage(ducking3);
        }
        else if (frame==4)
        {
            setImage(ducking4);
            frame = 1;
            return;
        }
    }
    /**
     * Checks if the player is jumping
     */
    private void checkJump()
    {
        if(upPressed && objectIsBelow() && isAlive) // If UP is pressed and there is an object below the player
        {
           jump();
        }
        else if (spacePressed && objectIsBelow() && isAlive) // If SPACE is pressed and there is an object below the player
        {
            jump();
        }
    }
    
    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    public void fall()
    {
        setLocation(getExactX(), getExactY() + ySpeed);

        if( ySpeed <= MAX_GRAV)   // If velocity is less than terminal velocity
        {
            ySpeed += GRAVITY_ACCEL;      // Accelerate
        }
    }

    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @return Returns true if there is an object at the coordinates passed in
     */
    public boolean objectIsBelow()
    {
        //List containing Actors the player is touching
        List<Actor> list = hitbox.getHitboxIntersectionsAtOffset(0, hitbox.getImage().getHeight() / 2 + 5, Actor.class);
        // If the Player's hitbox is touching any actor besides itself
        if (list.size() > 0 && !(list.get(0) instanceof Player))
        {
            //System.out.println(list.get(0));
            return true;
        }
        // If the player is on the edge of the world
        else if (hitbox.getY() >= getWorld().getHeight() - getImage().getHeight() + 200)
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
        ySpeed = -20.00; // Set vertical velocity to negative
        setLocation(getExactX(), getExactY() + ySpeed); // leave ground
    }
    
    /**
     * Determines if the player should fall or not
     */
    public void checkGravity()
    {
        if (objectIsBelow() && isAlive)    // If object is on solid ground and is alive
        {
            ySpeed = 0.0;   // Set vertical speed to 0
        }
        else
        {
            fall();
        }
    }
    
    /**
     * Checks if the player is touching an obstacle
     */
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
                SkiWorld w = (SkiWorld) getWorld();
                
                if(hits.size() <= 3)
                {
                    w.removeObject(w.getHealth(hits.size() -1));
                }
            }
            
            if(hits.size() >= 3)
            {
                this.setImage(hit);
                isAlive = false;
                SkiWorld w = (SkiWorld)getWorld();
                w.setIsAlive(isAlive);
                die.play();
                //setImage(hit);
            }
        }
    }
    
    /**
     * Checks if the obstacle has already been hit
     * 
     * @param Actor The Obstacle to test
     */
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
    
    /**
     * Please briefly describe what this method does
     */
    private void delayImage()
    {
        delay--;
        if(delay <= 0)
        {
            didGetHit = false;
            delay = DELAY;
        }
    }

    public void endLevel()
    {
        if( isTouching( Lodge.class ) )
        {
            BuildWorld b = new BuildWorld();      
            Greenfoot.setWorld(b);
        }
    }
    
    public void checkForMaterials()
    {
        Actor m = getOneIntersectingObject(Material1.class);
        if (m !=null)
        {   SkiWorld world =(SkiWorld) getWorld();
            MaterialBar materialbar =world.getMaterialBar();
            /*if(touchingMaterial1 ==false)
            { */
                materialbar.loseHealth();
                //touchingMaterial1 =true;
                //if(materialbar.mbhealth <=0)
                //{
                    
                //}
            //} */
            BuildWorld.count += 1;
            world.removeObject(m);
        }

        
    }
    
    public void checkForPower()
    {
        Actor p = getOneIntersectingObject(Power.class);
        if(p != null)
        {
            boolean collected = false;
            for(int i = 0; i < totalp.size(); i++)
            {
                if(p == totalp.get(i))
                {
                    collected = true;
                }
            }
            
            if(collected == false)
            {
                totalp.add((Power)p);
                SkiWorld w = (SkiWorld) getWorld();
                w.removeObject(p);
                
                SkiWorld world =(SkiWorld) getWorld();
                MaterialBar materialbar =world.getMaterialBar();
                materialbar.loseHealth();
                //System.out.println(totalp.size());
            }
            
        }
    }
    
    public void checkForShield()
    {
        Actor s = getOneIntersectingObject(Shield.class);
        if(s != null)
        {
            boolean collected = false;
            for(int i = 0; i < totals.size(); i++)
            {
                if(s == totals.get(i))
                {
                    collected = true;
                }
            }
            
            if(collected == false)
            {
                totals.add((Shield)s);
                SkiWorld w = (SkiWorld) getWorld();
                w.removeObject(s);
                
                SkiWorld world =(SkiWorld) getWorld();
                MaterialBar materialbar =world.getMaterialBar();
                materialbar.loseHealth();
                //System.out.println(totalp.size());
            }
            
        }
    }

    public void checkForLedge()
    {
        //suspend ledges as ground ?
        Actor l = hitbox.getOneIntersectingObjectPublic(Ledge.class);
        if(l != null && !objectIsBelow() )
        {
            fall();
        }
    }
}
