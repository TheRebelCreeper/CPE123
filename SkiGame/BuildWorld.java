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
   
    private GreenfootImage bimg;
    private SkierBuild skierbuild;
    private StartButtonBuildWorld startButton;
    private boolean isButtonClicked;
    private Container[] myContainers;
    private final int NUM_OF_CONTAINERS = 3;
    public static int count = 0;
    private Star star;
    
    public static int level;
    

    public BuildWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 500, 1, false); 
        bimg = new GreenfootImage("BackgroundEx.png");
        myContainers = new Container[NUM_OF_CONTAINERS];
        prepare();
        setPaintOrder(Hitbox.class);
        
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(startButton) || isButtonClicked)
        {
            skierbuild.move(5);
            isButtonClicked = true;
        }
        changeMainMenu();
    }

    public void changeMainMenu()
    {
        if (skierbuild.getX() > 850){
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
        addObject(snow,450,500);

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
        addObject(skierbuild, 250, 250);
        
        startButton = new StartButtonBuildWorld();
        addObject(startButton, getWidth() - 55, 30);

        setTrees();
    }
    
    public void setLevel(int l)
    {
        level = l;
    }
    
    public void setTrees1()
    {
        Tree t1 = new Tree();
        t1.setImage("buildtree.png");
        t1.setSpeed(0);
        addObject(t1, 400, -300);
        Tree t2 = new Tree();
        t2.setImage("buildtree.png");
        t2.setSpeed(0);
        addObject(t2, 500, -300);
        Tree t3 = new Tree();
        t3.setSpeed(0);
        t3.setImage("buildtree.png");
        addObject(t3, 600, -300);
    }
    
    public void setTrees2()
    {
        setTrees1();
        Tree t4 = new Tree();
        t4.setSpeed(0);
        t4.setImage("buildtree.png");
        addObject(t4, 700, -300);
    }
    
    public void setTrees3()
    {
        setTrees2();
        Tree t5 = new Tree();
        t5.setSpeed(0);
        t5.setImage("buildtree.png");
        addObject(t5, 800, -300);
    }
    
    public void setTrees4()
    {
        setTrees3();
        Tree t6 = new Tree();
        t6.setSpeed(0);
        t6.setImage("buildtree.png");
        addObject(t6, 900, -300);
    }
    
    public void setTrees5()
    {
        setTrees4();
        Tree t7 = new Tree();
        t7.setSpeed(0);
        t7.setImage("buildtree.png");
        addObject(t7, 1000, -300);
    }
    
    public void setTrees()
    {
        if(level == 1)
        {
            setTrees1();
        }
        if(level == 2)
        {
            setTrees2();
        }
        if(level == 3)
        {
            setTrees3();
        }
        if(level == 4)
        {
            setTrees4();
        }
        if(level == 5)
        {
            setTrees5();
        }
    }
}