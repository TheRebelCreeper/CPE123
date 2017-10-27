import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkiWorld
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkiWorld extends World
{
    /**Holds the background of SkiWorld*/
    private GreenfootImage myBackground;

    private int imageCount = 0;

    private int levelNumber = 1;
    /**Whether the player is alive or not*/
    public boolean isAlive = true;
    
    Heart[] health = new Heart[3];

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

    /**
     * Prepares the Actors in SkiWorld
     */
    private void prepare()
    {
        //Adds the player
        Player player = new Player();
        addObject(player, 297, 195);
        //Adds the slope
        Snow snow = new Snow();
        addObject(snow,298,399);
        //Adds the heart
        health[2] = new Heart();
        addObject(health[2], getWidth()-50, 50);
        health[1] = new Heart();
        addObject(health[1], getWidth()-95, 50);
        health[0] = new Heart();
        addObject(health[0], getWidth()-140, 50);
    }

    /**
     * Act method for SkiWorld
     */
    public void act()
    {
        //Checks what the level number is
        if (levelNumber % 5 == 0)
        {
            //Building interface
        }

        if(isAlive) // If the player is alive
        {
            imageCount -= 3;
            drawBackgroundImage(); // Updates the background          
            generateTree();     // Generates a tree
            generateBird();     // Generates a bird
            generateSnowball(); // Generates a snowball
        }
    }

    /**
     * Makes the background move over time
     * 
     * Please comment this Tony
     */
    public void drawBackgroundImage()
    {
        if( imageCount < -myBackground.getWidth() )
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
        Greenfoot.setWorld(new SkiWorldOver());
    }

    /**
     * Randomly generates Trees
     */
    private void generateTree()
    {
        if(Greenfoot.getRandomNumber(1000) < 5) // 0.5% chance of spawning a tree
        {
            Tree tree = new Tree();
            addObject(tree, 680, 230);

            //Material1 Material1 = new Material1();
            //addObject(Material1, 670, 190);
        }
    }

    /**
     * Randomly generates Birds
     */
    private void generateBird()
    {
        if(Greenfoot.getRandomNumber(1000) < 3) // 0.3% chance of spawning a bird
        {
            Bird bird = new Bird();
            addObject(bird, 680, 200);
        }
    }

    /**
     * Randomly generates Snowballs
     */
    private void generateSnowball()
    {
        if(Greenfoot.getRandomNumber(1000) < 2) // 0.2% chance of spawning a snowball
        {
            Snowball sb = new Snowball();
            addObject(sb, 680, 200);
        }
    }
    
    public Heart getHealth(int n)
    {
        return health[n];
    }
}
