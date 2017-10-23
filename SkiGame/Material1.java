import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Material1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material1 extends Actor
{
    protected final int GRAVITY_ACCEL = 1;
    protected final int MAX_GRAV = 15;
    protected int ySpeed = 0;
    private GreenfootImage myImage;
    /**
     * Act - do whatever the Material1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Material1()
    {
        myImage = new GreenfootImage("Material1.png");
        setImage(myImage);
        setRotation(10);
    }
    
    public void act() 
    {
        // Add your action code here.
        move(-6);
        checkRemove();
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
    
    
    protected void checkRemove()
    {
        if (getX() < 0)
        {
            getWorld().removeObject(this);
        }
    }
    
    
    
  
    
}
