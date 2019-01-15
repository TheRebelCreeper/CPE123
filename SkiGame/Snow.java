import greenfoot.*;

/**
 * Write a description of class Snow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Snow extends Actor
{
    /**
     * Constructor for Snow
     */
    public Snow()
    {
        setRotation(10);
        setImage(new GreenfootImage("WorkingSlope.png"));
    }

    public void addedToWorld(World w)
    {
        try
        {
            if (getWorldOfType(BuildWorld.class) != null)
            {
                setImage(new GreenfootImage("WorkingSlopeBW.png"));
            }
            else
            {
                setImage(new GreenfootImage("WorkingSlope.png"));
            }
        }
        catch (Exception e)
        {

        }
    }

    /**
     * Act - do whatever the Snow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public void changePicture(GreenfootImage i)
    {
        setImage(i);
    }
}
