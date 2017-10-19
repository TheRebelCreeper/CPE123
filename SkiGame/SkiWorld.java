import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SkiWorld
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkiWorld extends World
{
    private GreenfootImage myBackground;
    private int imageCount = 0;
    private int levelNumber = 1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public SkiWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        myBackground = new GreenfootImage("Background1.png");
        setBackground(myBackground);
        prepare();
        setPaintOrder(Player.class, Obstacle.class);
    }
    
    private void prepare()
    {
        Player player1 = new Player(200.0);
        addObject(player1, 297, 200);
        Snow snow = new Snow();
        addObject(snow,298,399);
        Tree tree = new Tree();
        addObject(tree,412,233);
    }
    
    public void act()
    {
        if(Greenfoot.getRandomNumber(1000) < 7)
        {
            Tree tree = new Tree();
            addObject(tree, 680, 230);
        }
        imageCount -= 3;
        drawBackgroundImage();
        
        if (levelNumber % 5 == 0)
        {
            //Building interface
        }
        if(Greenfoot.getRandomNumber(1000) < 3)
        {
            Snowball sb = new Snowball();
            addObject(sb, 680, 200);
        }
          if(Greenfoot.getRandomNumber(1000) < 3)
        {
            Bird bird = new Bird();
            addObject(bird, 680, 200);
        }
    
    
    
    
    
    }
    
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
}
