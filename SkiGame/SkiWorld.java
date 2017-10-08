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
        Player player1 = new Player();
        addObject(player1, 300, 182);
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
            addObject(tree, 630, 230);
        }
        imageCount -= 1;
        drawBackgroundImage();
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
