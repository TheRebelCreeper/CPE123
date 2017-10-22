import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Material1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material1 extends Material
{
    /**
     * Act - do whatever the Material1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(-6);
        
    }    
    
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
