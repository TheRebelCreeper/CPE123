import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
     */
    private int xOffset = 0;
    private final static int SWIDTH = 600;
    private final static int SHEIGHT = 400;
    private final static int WWIDTH = 1000;
    private GreenfootImage bimg;
    public BuildWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(SWIDTH, SHEIGHT, 1, false); 
        bimg = new GreenfootImage("BackgroundEx.png");
        shiftWorld(0);
        prepare();

    }

    /**
     * Prepares the objects in BuildWorld
     */
    public void prepare()
    {   
        Snow snow = new Snow();
        addObject(snow,298,399);

        Tree tree = new Tree();
        //addObject(tree,489,252);

        // Material1 material1 = new Material1();
        // addObject(material1,73,204);
        // material1.setLocation(191,204);
        // material1.setLocation(162,205);
        // material1.setLocation(68,188);

        Container container = new Container();
        addObject(container,74,71);

        Container container2 = new Container();
        addObject(container2,74,204);

        Container container3 = new Container();
        addObject(container3,74,332);

        Buildable buildable = new Buildable();
        container.setObject(buildable);
        addObject(buildable,74,71);

        Buildable buildable2 = new Buildable();
        container2.setObject(buildable2);
        addObject(buildable2,74,203);

        Buildable buildable3 = new Buildable();
        container3.setObject(buildable3);
        addObject(buildable3,74,333);
        SkierBuild skierbuild = new SkierBuild();
        addObject(skierbuild,303,197);
    }

    public void shiftWorld(int dx) {
        if( (xOffset + dx) <= 0 && (xOffset + dx) >= SWIDTH - WWIDTH) {
            xOffset = xOffset + dx;
            shiftWorldBackground(dx);
            shiftWorldActors(dx);
        }
    }

    private void shiftWorldBackground(int dx) {
        GreenfootImage bkgd = new GreenfootImage(SWIDTH, SHEIGHT);
        bkgd.drawImage(bimg, xOffset, 0);
        setBackground(bkgd);
    }

    private void shiftWorldActors(int dx) {
        List<ScrollingActor> saList =
            getObjects(ScrollingActor.class);
        for( ScrollingActor a : saList ) {
            a.setAbsoluteLocation(dx);
        }
    }


}
