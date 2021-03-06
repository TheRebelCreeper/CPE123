import greenfoot.*;

/**
 * Write a description of class BuildWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BuildWorld extends World
{
    private static final int NUM_OF_CONTAINERS = 8;
    public static int countRamp = 3;
    public static int countPowerup = 3;
    public static int countShield = 2;
    public static int level = 5;
    /**
     * Constructor for objects of class BuildWorld.
     */
    private int xOffset = 0;
    private GreenfootImage bimg;
    private SkierBuild skierbuild;
    private StartButtonBuildWorld startButton;
    private boolean isButtonClicked;
    private Container[] myContainers;

    public BuildWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 500, 1, false);
        bimg = new GreenfootImage("BackgroundEx.png");
        setBackground(bimg);
        myContainers = new Container[NUM_OF_CONTAINERS];
        prepare();
        setPaintOrder(ContainerHitbox.class, Hitbox.class);

    }

    public static boolean isFull()
    {
        return (countRamp + countPowerup + countShield >= NUM_OF_CONTAINERS);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(startButton) || isButtonClicked)
        {
            skierbuild.move(5);
            isButtonClicked = true;
        }

        if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new LevelMenu());
        }
        changeMainMenu();
    }

    public void changeMainMenu()
    {
        if (skierbuild.getX() > getWidth() - 50)
        {
            LevelMenu world = new LevelMenu();
            world.setStar(SkiWorld.getLevel());
            if (SkiWorld.getLevel() == 5)
            {
                world.addObject(new Label("YOU WIN", 96), 300, 100);
            }
            Greenfoot.setWorld(world);
        }
    }

    /**
     * Prepares the objects in BuildWorld
     */
    public void prepare()
    {
        Snow snow = new Snow();
        addObject(snow, 450, 500);

        Tree tree = new Tree();
        //addObject(tree,489,252);

        for (int i = 0; i < countRamp + countPowerup + countShield; i++)
        {
            myContainers[i] = new Container();
            addObject(myContainers[i], 50, (i * 62) + 33);
        }

        int c = 0;
        for (int i = 0; i < countRamp && c < NUM_OF_CONTAINERS; i++)
        {
            myContainers[c].setObject(new Ramp());
            c++;
        }

        for (int i = 0; i < countPowerup && c < NUM_OF_CONTAINERS; i++)
        {
            myContainers[c].setObject(new PowerUpBuild());
            c++;
        }

        for (int i = 0; i < countShield && c < NUM_OF_CONTAINERS; i++)
        {
            myContainers[c].setObject(new ShieldBuild());
            c++;
        }

        for (int i = 0; i < countRamp + countPowerup + countShield; i++)
        {
            if (myContainers[i].getObject() != null)
            {
                addObject(myContainers[i].getObject(), 50, (i * 62) + 33);
            }
        }

        skierbuild = new SkierBuild();
        addObject(skierbuild, 190, 200);

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
        addObject(t2, 620, -300);
        Tree t3 = new Tree();
        t3.setSpeed(0);
        t3.setImage("buildtree.png");
        addObject(t3, 840, -300);
    }

    public void setTrees2()
    {
        Tree t1 = new Tree();
        t1.setImage("buildtree.png");
        t1.setSpeed(0);
        addObject(t1, 400, -300);
        Tree t2 = new Tree();
        t2.setImage("buildtree.png");
        t2.setSpeed(0);
        addObject(t2, 575, -300);
        Tree t3 = new Tree();
        t3.setSpeed(0);
        t3.setImage("buildtree.png");
        addObject(t3, 750, -300);
        Tree t4 = new Tree();
        t4.setSpeed(0);
        t4.setImage("buildtree.png");
        addObject(t4, 925, -300);
    }

    public void setTrees3()
    {
        Tree t1 = new Tree();
        t1.setImage("buildtree.png");
        t1.setSpeed(0);
        addObject(t1, 350, -300);
        Tree t2 = new Tree();
        t2.setImage("buildtree.png");
        t2.setSpeed(0);
        addObject(t2, 540, -300);
        Tree t3 = new Tree();
        t3.setSpeed(0);
        t3.setImage("buildtree.png");
        addObject(t3, 700, -300);
        Tree t4 = new Tree();
        t4.setSpeed(0);
        t4.setImage("buildtree.png");
        addObject(t4, 730, -300);
        Tree t5 = new Tree();
        t5.setSpeed(0);
        t5.setImage("buildtree.png");
        addObject(t5, 875, -300);
    }

    public void setTrees4()
    {
        Tree t1 = new Tree();
        t1.setImage("buildtree.png");
        t1.setSpeed(0);
        addObject(t1, 350, -300);
        Tree t2 = new Tree();
        t2.setImage("buildtree.png");
        t2.setSpeed(0);
        addObject(t2, 520, -300);
        Tree t3 = new Tree();
        t3.setSpeed(0);
        t3.setImage("buildtree.png");
        addObject(t3, 570, -300);
        Tree t4 = new Tree();
        t4.setSpeed(0);
        t4.setImage("buildtree.png");
        addObject(t4, 760, -300);
        Tree t5 = new Tree();
        t5.setSpeed(0);
        t5.setImage("buildtree.png");
        addObject(t5, 790, -300);
        Tree t6 = new Tree();
        t6.setSpeed(0);
        t6.setImage("buildtree.png");
        addObject(t6, 930, 100);
    }

    public void setTrees5()
    {
        Tree t1 = new Tree();
        t1.setImage("buildtree.png");
        t1.setSpeed(0);
        addObject(t1, 350, -300);
        Tree t2 = new Tree();
        t2.setImage("buildtree.png");
        t2.setSpeed(0);
        addObject(t2, 520, -300);
        Tree t3 = new Tree();
        t3.setSpeed(0);
        t3.setImage("buildtree.png");
        addObject(t3, 550, -300);
        Tree t4 = new Tree();
        t4.setSpeed(0);
        t4.setImage("buildtree.png");
        addObject(t4, 580, -300);
        Tree t5 = new Tree();
        t5.setSpeed(0);
        t5.setImage("buildtree.png");
        addObject(t5, 730, -300);
        Tree t6 = new Tree();
        t6.setSpeed(0);
        t6.setImage("buildtree.png");
        addObject(t6, 760, -300);
        Tree t7 = new Tree();
        t7.setSpeed(0);
        t7.setImage("buildtree.png");
        addObject(t7, 910, -300);
    }

    public void setTrees()
    {
        if (level == 1)
        {
            setTrees1();
        }
        if (level == 2)
        {
            setTrees2();
        }
        if (level == 3)
        {
            setTrees3();
        }
        if (level == 4)
        {
            setTrees4();
        }
        if (level == 5)
        {
            setTrees5();
        }
    }
}