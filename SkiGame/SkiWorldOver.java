import greenfoot.*;

/**
 * Write a description of class SkiWorldOver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SkiWorldOver extends World
{
    private World nextWorld;

    /**
     * Constructor for objects of class SkiWorldOver.
     */
    public SkiWorldOver(boolean t)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        nextWorld = (t == true) ? new SkiWorld() : new BuildWorld();
        setBackground(new GreenfootImage("gameoverdesu.jpg"));
    }

    /**
     * Act method for SkiWorldOver
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(nextWorld);
        }
    }
}
