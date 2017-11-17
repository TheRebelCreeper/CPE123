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
        setRotation(10);
        setImage(new GreenfootImage("ramptri.png"));
    }
    
    protected void addedToWorld(World w)
    {
        hitbox = new RampHitbox(this, 125, 5, 0, 0, true); // Set to false for invisible hitbox
        getWorld().addObject(hitbox, getX(), getY());   // Adds the hitbox to the world
        hitbox.setRotation(getRotation() - 28);
    }
    
    /**
     * Act - do whatever the Ramp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }   
}
