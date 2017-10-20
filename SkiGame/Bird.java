import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Obstacle
{
    /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Bird()
    {
        setRotation(10);
        setImage(new GreenfootImage("bird1.png"));
    }
    
    
    public void act() 
    {
        move (-8);
        checkRemove();
    }    
}
