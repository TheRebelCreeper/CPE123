import greenfoot.*;

/**
 * Write a description of class Snowball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Snowball extends Obstacle
{
    public static double speed;

    /**
     * Constructor for Snowball
     */
    public Snowball()
    {
        setRotation(9);
        speed = -7;
    }

    /**
     * Act - do whatever the Snowball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-7);
        checkRemove();
    }

    public void snowBallImage()
    {
        if (((SkiWorld) getWorld()).getLevel() == 1)
        {
            setImage(new GreenfootImage("snowball.png"));
        }
        else if (((SkiWorld) getWorld()).getLevel() == 2)
        {
            setImage(new GreenfootImage("tumbleweed.png"));
        }
        else if (((SkiWorld) getWorld()).getLevel() == 3)
        {
            setImage(new GreenfootImage("snowball.png"));
        }
        else if (((SkiWorld) getWorld()).getLevel() == 4)
        {
            setImage(new GreenfootImage("asteroid.png"));
        }
        else if (((SkiWorld) getWorld()).getLevel() == 5)
        {
            setImage(new GreenfootImage("snowball.png"));
        }
    }

    public void setSpeed(int l)
    {
        if (l != 0)
        {
            int difference = l - 1;
            speed = -7 - difference + .5 * (l - 1);
        }
    }
}
