import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends SmoothMover
{
    public static double speed;
    

    
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shield()
    {
        setRotation(10);
        speed = -6;
        
    }
    
    public void act() 
    {
        move(speed);
        checkRemove();
    } 
    
    public void setSpeed(int l)
    {
        if(l != 0)
        {
            int difference = l - 1;
            speed = -6 - difference + .5*(l-1);
        }
    }
    
    public void checkRemove()
    {
        if(getX() < -20)
        {
            this.getWorld().removeObject(this);
        }
    }
}
