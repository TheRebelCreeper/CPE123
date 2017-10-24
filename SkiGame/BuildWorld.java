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
        removeObject(toolbar);
        Buildable buildable = new Buildable();
        addObject(buildable,84,79);
        Buildable buildable2 = new Buildable();
        addObject(buildable2,90,213);
        Buildable buildable3 = new Buildable();
        addObject(buildable3,97,344);
        buildable3.setLocation(89,341);
        buildable2.setLocation(84,207);
        buildable3.setLocation(85,334);
        removeObject(buildable2);
        removeObject(buildable);
        removeObject(buildable3);
        material1.getImage();
        Container container = new Container();
        addObject(container,74,71);
        Container container2 = new Container();
        addObject(container2,82,206);
        Container container3 = new Container();
        addObject(container3,92,340);
        container2.setLocation(74,204);
        container3.setLocation(75,332);
        Buildable buildable4 = new Buildable();
        container.setObject(buildable4);
        addObject(buildable4,74,79);
    }
    








}
