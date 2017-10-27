import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buildable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buildable extends Actor implements Gravity
{
    /**Instance variable for the MouseInfo*/
    private MouseInfo mi;
    /**Placed holds the current state of the Actor. 
     * 0 for not clicked yet, 
     * 1 for moving around, 
     * 2 for placed*/
    private int placed;
    
    /**Holds the speed of the Actor*/
    private int ySpeed;
    
    /**
     * Constructor for buildable
     */
    public Buildable()
    {
        placed = 0;
        ySpeed = 0;
    }
    
    /**
     * Act - do whatever the Buildable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //controls where to place the object
        if (placed == 1)    // If the container has been clicked
        {
            mi = Greenfoot.getMouseInfo();
            if (mi != null) // If the mouse is on the window
                setLocation(mi.getX(), mi.getY());  // Set to location to the current mouse position
        }
        
        // Controls placing the object
        if (Greenfoot.mouseClicked(this) && placed == 1)    // If the object is clicked on
        {
            if (isValidLocation())
            {
                placed = 2; // Place the object
            }
        }
        
        if (placed == 2)
        {
            checkGravity(); // Gravity will now affect the buildable
            //All normal functionality goes in this if statement
        }
    }    
    
    /**
     * Checks if the posision where the object is placed is valid
     * 
     * To be implemented later
     * 
     * @return  Returns true if the location is valid
     */
    private boolean isValidLocation()
    {
        return true;
    }
    
    /**
     * Setter for the placed variable
     * 
     * @param int placed    Value to set placed to
     */
    public void setPlaced(int placed)
    {
        this.placed = placed;
    }
    
    /**
     * Determines if the player should fall or not
     */
    public void checkGravity()
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
    public boolean objectIsBelow()
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
    public void fall()
    {
        setLocation(getX(), getY() + ySpeed);
        if( ySpeed <= MAX_GRAV)   // Terminal Velocity
        {
            ySpeed += GRAVITY_ACCEL;
        }
    }
}
