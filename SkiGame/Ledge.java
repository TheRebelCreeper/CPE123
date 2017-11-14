import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ledge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ledge extends SmoothMover
{
    public static double speed;
    /**
     * Act - do whatever the Ledge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void prepare()
    {
        setRotation(10);
        setImage("ledge.png");
        speed = -6;
    }
    
    public void act() 
    {
        // Add your action code here.
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
