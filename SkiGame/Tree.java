import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trees here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Obstacle
{
    private GreenfootImage myImage;
    
    /**
     * Constructor
     */
    public Tree()
    {
        setRotation(10);
        myImage = new GreenfootImage("pine-tree.png");
        setImage(myImage);
    }
   
    
    /**
     * Act - do whatever the Trees wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(-6);
        checkGravity();
        checkRemove();
    } 
    
    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @return Returns true if there is an object at the coordinates passed in
     */
    @Override
    protected boolean objectIsBelow()
    {
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Actor.class) != null)
        {
            if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Tree.class) == null)
                return true;
            else
                return false;
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
}
