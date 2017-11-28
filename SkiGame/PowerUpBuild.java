import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUpBuild here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUpBuild extends Buildable
{
    /**
     * Act - do whatever the PowerUpBuild wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //controls where to place the object
        if (placed == 1)    // If the container has been clicked
        {
            setImage(baseImage);
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
}
