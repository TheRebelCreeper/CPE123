import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends World
{

    /**
     * Constructor for objects of class Rules.
     * 
     */
    public Rules()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(new GreenfootImage("instructionsDos.png"));
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            LevelMenu world = new LevelMenu();
            Greenfoot.setWorld(world);
         }
    }
}
