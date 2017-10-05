import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkiWorld
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkiWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public SkiWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
    }
    
    private void prepare()
    {
        Player player1 = new Player();
        addObject(player1, 300, 200);
        Snow snow = new Snow();
        addObject(snow,298,399);
        Tree tree = new Tree();
        addObject(tree,420,235);
        tree.setLocation(412,233);
    }
}
