import greenfoot.*;

/**
 * Write a description of class Story here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Story extends World
{

    /**
     * Constructor for objects of class Story.
     */
    public Story()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground(new GreenfootImage("story.png"));

    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            Rules rWorld = new Rules();
            Greenfoot.setWorld(rWorld);
        }
    }
}
