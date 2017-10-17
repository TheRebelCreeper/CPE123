import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @Tony Bone, Ritu Bhalodia, Elena Fowler, Aaron Lampert, Jarod Morris
 * @Beta 0.1
 */
public class Player extends Actor
{
    private final int GRAVITY_ACCEL = 1;
    private final int MAX_GRAV = 10;
    private int ySpeed = 0;
    
    
    private GreenfootImage up;
    private GreenfootImage down;

    /**
     * Constructor
     */
    public Player()
    {
        setRotation(10);
        up = new GreenfootImage("skiernormal.png");
        down = new GreenfootImage("skierducking.png");
        setImage(up);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkGravity();

        if(Greenfoot.isKeyDown("up") && objectIsBelow()) //jumping key
        {
            jump();
        }
        else if (Greenfoot.isKeyDown("space") && objectIsBelow())
        {
            jump();
        }
        
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("shift"))// animation for skier to duck
        { 
            setImage(down);   
        }
        else 
        {
            setImage(up);  
        }
    }    

    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    private void fall()
    {
        setLocation(getX(), getY() + ySpeed);
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
        else if (getY() >= getWorld().getHeight() - getImage().getHeight())
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
        ySpeed = -15; //add jump speed?
        setLocation(getX(), getY() + ySpeed); //leave ground
    }
    
    /**
     * Determines if the player should fall or not
     */
    private void checkGravity()
    {
        if (objectIsBelow())    // If object is on solid ground
        {
            ySpeed = 0;
        }
        else
        {
            fall();
        }
    }
}
