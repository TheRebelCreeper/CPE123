import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkiWorldIntro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkiWorldIntro extends World
{

    /**
     * Constructor for objects of class SkiWorldIntro.
     * 
     */
    public SkiWorldIntro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            SkiWorld world = new SkiWorld();
            Greenfoot.setWorld(world);
         }
    }
    
}