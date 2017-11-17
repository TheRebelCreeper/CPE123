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
    private final static int SWIDTH = 900;
    private final static int SHEIGHT = 500;
    private final static int WWIDTH = 1000;
    private GreenfootImage bimg;
    SkierBuild skierbuild;
    StartButtonBuildWorld startbuttonbuildworld;
    private boolean isButtonClicked;
    private Container[] myContainers;
    private final int NUM_OF_CONTAINERS = 3;
    public static int count = 0;
    private Star star;
    
    

    public BuildWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(SWIDTH, SHEIGHT, 1, false); 
        bimg = new GreenfootImage("BackgroundEx.png");
        shiftWorld(0);
        myContainers = new Container[NUM_OF_CONTAINERS];
        prepare();
        setPaintOrder(Hitbox.class);
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(startbuttonbuildworld) || isButtonClicked)
        {
            skierbuild.move(5);
            isButtonClicked = true;
        }
        changeMainMenu();
    }

    public void changeMainMenu()
    {
        if (skierbuild.getX() > 560){
            LevelMenu world = new LevelMenu();
            Greenfoot.setWorld(world);
            if (SkiWorld.getLevel() == 1){
                star = new Star();
                world.addObject(star,51,261);
            }
            if (SkiWorld.getLevel() == 2){
                star = new Star();
                world.addObject(star,51,261);
                world.addObject(star,160,260);
            }
            if (SkiWorld.getLevel() == 3){
                star = new Star();
                world.addObject(star,51,261);
                world.addObject(star,160,260);
                world.addObject(star,272,259);
            }
            if (SkiWorld.getLevel() == 4){
                star = new Star();
                world.addObject(star,51,261);
                world.addObject(star,160,260);
                world.addObject(star,272,259);
                world.addObject(star,389,262);
            }
            if (SkiWorld.getLevel() == 5){
                star = new Star();
                world.addObject(star,51,261);
                world.addObject(star,160,260);
                world.addObject(star,272,259);
                world.addObject(star,389,262);
                world.addObject(star,501,260);
            }
        }
    }

    /**
     * Prepares the objects in BuildWorld
     */
    public void prepare()
    {   
        Snow snow = new Snow();
        addObject(snow,450,475);

        Tree tree = new Tree();
        //addObject(tree,489,252);

        myContainers[0] = new Container();
        addObject(myContainers[0],74,71);

        myContainers[1] = new Container();
        addObject(myContainers[1],74,204);

        myContainers[2] = new Container();
        addObject(myContainers[2],74,332);

        for (int i = 0; i < count && i < NUM_OF_CONTAINERS; i++)
        {
            myContainers[i].setObject(new Ramp());
        }

        if (myContainers[0].getObject() != null)
        {
            addObject(myContainers[0].getObject(),74,71);
        }

        if (myContainers[1].getObject() != null)
        {
            addObject(myContainers[1].getObject(),74,203);
        }

        if (myContainers[2].getObject() != null)
        {
            addObject(myContainers[2].getObject(),74,333);
        }

        skierbuild = new SkierBuild();
        addObject(skierbuild,303,197);
        startbuttonbuildworld = new StartButtonBuildWorld();
        addObject(startbuttonbuildworld,522,338);
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