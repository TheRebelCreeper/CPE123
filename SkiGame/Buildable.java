import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buildable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buildable extends Actor
{
    private MouseInfo mi;
    private int placed;
    
    private final int GRAVITY_ACCEL = 1;
    private final int MAX_GRAV = 10;
    private int ySpeed = 0;
    
    public Buildable()
    {
        placed = 0;
        mi = Greenfoot.getMouseInfo();
    }
    
    /**
     * Act - do whatever the Buildable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mi = Greenfoot.getMouseInfo();
        if (placed == 1)
        {
            if (mi != null)
                setLocation(mi.getX(), mi.getY());
        }
        
        if (Greenfoot.mouseClicked(this) && placed == 1)
        {
            if (isValidLocation())
            {
                placed = 2;
            }
        }
        
        if (placed == 2)
        {
            checkGravity();
        }
    }    
    
    private boolean isValidLocation()
    {
        return true;
    }
    
    public void setPlaced(int placed)
    {
        this.placed = placed;
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
}
