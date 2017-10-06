import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snow extends Actor
{
    private GreenfootImage myImage;
    
    /**
     * Act - do whatever the Snow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Snow()
    {
        setRotation(10);
        myImage = new GreenfootImage("WorkingSlope.png");
        setImage(myImage);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
