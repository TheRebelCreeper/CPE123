import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Ramp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ramp extends Buildable
{
    private RampHitbox hitbox;
    
    public Ramp()
    {
        super();
        setRotation(10);
        baseImage = new GreenfootImage("ramp.png");
    }
    
    protected void addedToWorld(World w)
    {
        hitbox = new RampHitbox(this, 150, 20, 7, 3, false); // Set to false for invisible hitbox
        getWorld().addObject(hitbox, getX(), getY());   // Adds the hitbox to the world
        hitbox.setRotation(getRotation() - 28);
    }
    
    /**
     * Act - do whatever the Ramp wants to do. This method is called whenever
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
        if (Greenfoot.mouseClicked(this) || Greenfoot.mouseClicked(hitbox) && placed == 1)    // If the object is clicked on
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
