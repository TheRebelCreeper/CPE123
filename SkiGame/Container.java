import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Container extends Actor
{
    /**The Buildable held in this Container*/
    private Buildable object;
    
    /**
     * Constructor for Container
     */
    public Container()
    {
        setImage(new GreenfootImage("ToolBar.png"));    // Sets the image
    }
    
    /**
     * Act - do whatever the Container wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // If this container was clicked on
        if (object != null && Greenfoot.mouseClicked(this))
        {
            object.setPlaced(1);    // Set the object's placed value to 1
        }
    }  
    
    /**
     * Setter for object
     * 
     * @param Buildable What this Container will hold
     */
    public void setObject(Buildable object)
    {
        this.object = object;
    }
    
    /**
     * Getter for object
     * 
     * @return Buildable Returns the object held in this Container
     */
    public Buildable getObject()
    {
        return object;
    }
}
