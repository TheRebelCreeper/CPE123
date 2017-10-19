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
    private boolean placed;
    
    public Buildable()
    {
        placed = true;
        mi = Greenfoot.getMouseInfo();
    }
    
    /**
     * Act - do whatever the Buildable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mi = Greenfoot.getMouseInfo();
        if (!placed)
        {
            if (mi != null)
                setLocation(mi.getX(), mi.getY());
        }
        
        if (Greenfoot.mouseClicked(this))
        {
            if (isValidLocation())
            {
                placed = true;
            }
        }
    }    
    
    private boolean isValidLocation()
    {
        return true;
    }
    
    public void setPlaced(boolean placed)
    {
        this.placed = placed;
    }
}
