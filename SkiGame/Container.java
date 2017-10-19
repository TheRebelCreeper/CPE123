import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Container extends Actor
{
    private Buildable object;
    
    /**
     * Act - do whatever the Container wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            if (object != null)
                object.setPlaced(false);
        }
    }  
    
    public void setObject(Buildable object)
    {
        this.object = object;
    }
    
    public Buildable getObject()
    {
        return object;
    }
}
