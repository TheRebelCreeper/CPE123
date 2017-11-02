import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lodge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lodge extends Actor implements Gravity
{
    protected int ySpeed = 0;
    /**
     * Act - do whatever the Lodge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @return Returns true if there is an object at the coordinates passed in
     */
    @Override
    public boolean objectIsBelow()
    {
        // If it is touching another Actor
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Actor.class) != null)
        {
            // If it isn't another Tree
            if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Tree.class) == null)
                return true;
            else
                return false;
        }
        // If it is touching the edge of the world
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
}
