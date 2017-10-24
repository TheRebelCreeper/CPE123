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
        setBackground(new GreenfootImage("Background1.png"));
    }


    public void prepare()
    {   Snow snow = new Snow();
        addObject(snow,298,399);

        Tree trees = new Tree();
        addObject(trees,467,247);
        trees.setLocation(489,252);
        Material1 material1 = new Material1();
        addObject(material1,73,204);
        material1.setLocation(191,204);
        material1.setLocation(162,205);
        material1.setLocation(68,188);
        material1.getImage();
        Container container = new Container();
        addObject(container,74,71);
        Container container2 = new Container();
        addObject(container2,82,206);
        Container container3 = new Container();
        addObject(container3,92,340);
        container2.setLocation(74,204);
        container3.setLocation(75,332);
        Buildable buildable = new Buildable();
        container.setObject(buildable);
        addObject(buildable,74,79);
    }
}
