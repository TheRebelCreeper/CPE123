import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Material1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material extends Actor implements Gravity
{
    protected int ySpeed = 0;
    
    public Material()
    {
        
    }
    
    /**
     * Act - do whatever the Material1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void fall()
    {
        if( ySpeed <= MAX_GRAV)   // If velocity is less than terminal velocity
        {
            ySpeed += GRAVITY_ACCEL;    // Accelerate
        }
    }
    
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
