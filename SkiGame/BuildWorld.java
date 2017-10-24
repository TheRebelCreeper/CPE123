import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuildWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildWorld extends World
{

    /**
     * Constructor for objects of class BuildWorld.
     * 
     */
    public BuildWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }


    public void prepare()
    {   Snow snow = new Snow();
        addObject(snow,298,399);
        Toolbar toolbar = new Toolbar();
        addObject(toolbar,86,209);
        toolbar.setLocation(72,206);

        Tree trees = new Tree();
        addObject(trees,467,247);
        trees.setLocation(489,252);
        Material1 material1 = new Material1();
        addObject(material1,73,204);
        material1.setLocation(191,204);
        material1.setLocation(162,205);
        material1.setLocation(68,188);
    }
    








}
