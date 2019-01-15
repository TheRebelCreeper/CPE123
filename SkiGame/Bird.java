import greenfoot.*;

/**
 * Write a description of class Bird here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bird extends Obstacle
{
    public static double speed;

    /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bird()
    {
        setRotation(10);
        setImage(new GreenfootImage("bird1.png"));
        speed = -6;
    }

    /**
     * Act method for Bird
     */
    public void act()
    {
        move(speed);
        checkRemove();
    }

    public void setSpeed(int l)
    {
        if (l != 1)
        {
            int difference = l - 1;
            speed = -6 - difference + .5 * (l - 1);
        }
    }
}
