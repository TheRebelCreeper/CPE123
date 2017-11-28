import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Power here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Power extends SmoothMover
{
    public static double speed;
    private GreenfootImage powerup;
    /**
     * Act - do whatever the Power wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Power()
    {
        setRotation(10);
        speed = -6;
        powerup = new GreenfootImage ("snowflakerainbow.png");
        setImage(powerup);
    }

    public void act() 
    {
        // Add your action code here.

        if( getWorld() instanceof SkiWorld )
        {
            move(speed);
        }
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
