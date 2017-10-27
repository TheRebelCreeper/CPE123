import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Obstacle extends Actor implements Gravity
{
    /**Vertical Velocity*/
    protected int ySpeed = 0;
    
    /**
     * Act - do whatever the Obstacles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public abstract void act();   
    
    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    public void fall()
    {
        setLocation(getX(), getY() + ySpeed);
        if( ySpeed <= MAX_GRAV)   // If velocity is less than terminal velocity
        {
            ySpeed += GRAVITY_ACCEL;    // Accelerate
        }
    }

    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @return Returns true if there is an object at the coordinates passed in
     */
    public boolean objectIsBelow()
    {
        // If there is an object right below the image
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Actor.class) != null)
        {
            return true;
        }
        // If the Actor is below the world
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
     * Determines if the player should fall or not
     */
    public void checkGravity()
    {
        if (objectIsBelow())    // If object is on solid ground
        {
            ySpeed = 0;     // Set vertical velocity to 0
        }
        else
        {
            fall();     // Fall due to gravity
        }
    }
    
    /**
     * Checks if the Actor should be removed from the world
     */
    protected void checkRemove()
    {
        if (getX() < 0)
        {
            getWorld().removeObject(this);
        }
    }
}
