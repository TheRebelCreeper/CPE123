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
    
    public Container()
    {
        setImage(new GreenfootImage("ToolBar.png"));
    }
    
    /**
     * Act - do whatever the Container wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (object != null && Greenfoot.mouseClicked(this))
        {
            object.setPlaced(1);
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
