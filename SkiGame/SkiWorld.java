import greenfoot.*;

/**
 * Write a description of class SkiWorld
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SkiWorld extends World
{
    /**
     * Current level of the game
     */
    public static int levelNumber = 1;
    public int obstacleDelay = 0;
    public int obstacleDELAY;
    /**
     * Holds the background of SkiWorld
     */
    private GreenfootImage myBackground;
    //private int treeSpawnRate, birdSpawnRate, snowballSpawnRate;
    private int spawnRate;
    private int imageCount = 0;
    /**
     * Whether the player is alive or not
     */
    private boolean isAlive = true;
    private Heart[] health = new Heart[3];
    private int lodgeDelay = 0;
    private Label label;
    private Player player;
    private Snow snow;
    private MaterialBar mb = new MaterialBar();

    /**
     * Constructor for objects of class MyWorld.
     */
    public SkiWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        myBackground = new GreenfootImage("Background1.png");
        setBackground(myBackground);    // Sets the background
        prepare();  // Adds the Actors

        // Order to draw Actors in 
        setPaintOrder(PlayerHitbox.class, Player.class, Obstacle.class);
    }

    public static int getLevel()
    {
        return levelNumber;
    }

    public static void setLevel(int level)
    {
        levelNumber = level;
    }

    /**
     * Prepares the Actors in SkiWorld
     */
    private void prepare()
    {
        //Adds the player
        player = new Player();
        addObject(player, 297, 195);
        //Adds the slope
        snow = new Snow();
        addObject(snow, 298, 399);
        //Adds the heart
        health[2] = new Heart();
        addObject(health[2], getWidth() - 50, 50);
        health[1] = new Heart();
        addObject(health[1], getWidth() - 95, 50);
        health[0] = new Heart();
        addObject(health[0], getWidth() - 140, 50);

        label = new Label("Level: " + levelNumber, 48);
        addObject(label, 100, 50);

        mb.setHealth(4);
        addObject(mb, 90, 350);

    }

    /**
     * Act method for SkiWorld
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("escape"))
        {
            Greenfoot.setWorld(new LevelMenu());
        }

        if (isAlive) // If the player is alive
        {
            if (levelNumber == 1)
            {
                imageCount -= 3;

                spawnRate = 200;

                drawBackgroundImage(); // Updates the background

                spawnObstacles();
                generateLodge();
            }
            else if (levelNumber == 2)
            {
                imageCount -= 3;

                spawnRate = 150;
                GreenfootImage bg = new GreenfootImage("sandbackground.png");
                myBackground = bg;
                GreenfootImage s = new GreenfootImage("sandslope.png");
                snow.setImage(s);
                drawBackgroundImage(); // Updates the background
                spawnObstacles();
                generateLodge();
            }
            else if (levelNumber == 3)
            {
                imageCount -= 3;

                spawnRate = 120;
                GreenfootImage t = new GreenfootImage("trees.png");
                myBackground = t;
                drawBackgroundImage(); // Updates the background
                spawnObstacles();
                generateLodge();
            }
            else if (levelNumber == 4)
            {
                imageCount -= 3;

                spawnRate = 100;
                GreenfootImage sb = new GreenfootImage("marsBackground.png");
                myBackground = sb;
                GreenfootImage s = new GreenfootImage("marsSlope.png");
                snow.setImage(s);

                drawBackgroundImage();

                drawBackgroundImage(); // Updates the background
                spawnObstacles();
                generateLodge();
            }
            else if (levelNumber == 5)
            {
                imageCount -= 3;

                spawnRate = 80;

                GreenfootImage last = new GreenfootImage("Background1.png");
                myBackground = last;
                drawBackgroundImage();
                spawnObstacles();
                generateLodge();
            }
        }
        lodgeDelay++;
    }

    /**
     * Makes the background move over time
     * <p>
     * Please comment this Tony
     */
    public void drawBackgroundImage()
    {
        if (imageCount < -myBackground.getWidth())
        {
            imageCount += myBackground.getWidth();
        }
        int temp = imageCount;
        getBackground().drawImage(myBackground, temp, 0);
        getBackground().drawImage(myBackground, temp + myBackground.getWidth(), 0);
    }

    /**
     * Setter for isAlive instance variable
     *
     * @param boolean True or false
     */
    public void setIsAlive(boolean a)
    {
        isAlive = a;
    }

    /**
     * Ends the game and creates a new SkiWorldOver
     */
    public void endGame()
    {
        Greenfoot.setWorld(new SkiWorldOver(true));
    }

    public void spawnObstacles()
    {
        obstacleDelay--;
        if (obstacleDelay <= 0)
        {
            int num = Greenfoot.getRandomNumber(6);
            if (num == 0 || num == 4 || num == 5)
            {
                generateTree();
            }
            if (num == 1)
            {
                generateBird();
            }
            if (num == 2)
            {
                generateSnowball();
            }
            if (num == 3)
            {
                generateLedge();
            }

            int d = Greenfoot.getRandomNumber(40) + spawnRate;
            obstacleDelay = d;
        }
    }

    /**
     * Randomly generates Trees
     */
    private void generateTree()
    {
        Tree tree = new Tree();
        tree.setSpeed(levelNumber);
        tree.treeImage();
        addObject(tree, 680, 230);

        int num = Greenfoot.getRandomNumber(2);
        int num2 = Greenfoot.getRandomNumber(2);

        if (num == 0)
        {
            if (num2 == 0)
            {
                Material1 material1 = new Material1();
                material1.setSpeed(levelNumber);
                addObject(material1, 670, 195);
            }
            if (num2 == 1)
            {
                Shield s = new Shield();
                s.setSpeed(levelNumber);
                addObject(s, 670, 195);
            }
        }
    }

    /**
     * Randomly generates Birds
     */
    private void generateBird()
    {
        //if(Greenfoot.getRandomNumber(1000) < birdSpawnRate) // Chance of spawning a bird
        //{
        Bird bird = new Bird();
        bird.setSpeed(levelNumber);
        addObject(bird, 680, 210);

        //}
    }

    /**
     * Randomly generates Snowballs
     */
    private void generateSnowball()
    {
        //if(Greenfoot.getRandomNumber(1000) < snowballSpawnRate) // Chance of spawning a snowball
        //{
        Snowball sb = new Snowball();
        sb.setSpeed(levelNumber);
        sb.snowBallImage();
        addObject(sb, 680, 210);
        //}
    }

    private void generateLedge()
    {
        Ledge l = new Ledge();
        l.setSpeed(levelNumber);
        addObject(l, 680, 210);
        //680,180

        Ledge l2 = new Ledge();
        l2.setSpeed(levelNumber);
        addObject(l2, 820, 150);

        int num = Greenfoot.getRandomNumber(2);

        if (num == 0)
        {
            Material1 material1 = new Material1();
            material1.setSpeed(levelNumber);
            addObject(material1, 800, 270);

            generatePower();
        }
        if (num == 1)
        {
            generatePower();
            generateShield();
        }
    }

    private void generatePower()
    {
        Power p = new Power();
        p.setSpeed(levelNumber);
        addObject(p, 820, 125);
    }

    private void generateShield()
    {
        Shield s = new Shield();
        s.setSpeed(levelNumber);
        addObject(s, 800, 270);
    }

    private void generateLodge()
    {
        if (lodgeDelay >= 1800 && (BuildWorld.countRamp + BuildWorld.countShield + BuildWorld.countPowerup >= 4))
        {
            setBuildWorldLevel();
            Lodge lodge = new Lodge();
            addObject(lodge, 600, 275);
        }

    }

    public Heart getHealth(int n)
    {
        return health[n];
    }

    public int getLodgeDelay()
    {
        return lodgeDelay;
    }

    public MaterialBar getMaterialBar()
    {
        return mb;
    }

    public void setBuildWorldLevel()
    {
        BuildWorld bw = new BuildWorld();
        bw.setLevel(levelNumber);
    }
}
