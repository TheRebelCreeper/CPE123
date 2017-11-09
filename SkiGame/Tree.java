import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trees here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Obstacle
{      
    
    public static double speed;
    /**
     * Constructor
     */
    public Tree()
    {
        setRotation(10);
        setImage(new GreenfootImage("pine-tree.png"));  // Sets the image of Tree
        speed = -6;
    }
   
    
    /**
     * Act - do whatever the Trees wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(speed);
        checkGravity();     // Checks the gravity for Tree
        checkRemove();      // Checks to remove Tree
    }
    
    public void setSpeed(int l)
    {
        int difference = l-1;
        speed = -6 - difference;
    }
    
    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @return Returns true if there is an object at the coordinates passed in
     */
    @Override
    public boolean objectIsBelow()
    {
        // If it is touching another Actor
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Actor.class) != null)
        {
            // If it isn't another Tree
            if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 2, Tree.class) == null)
                return true;
            else
                return false;
        }
        // If it is touching the edge of the world
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
