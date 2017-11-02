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
        speed = -6;
    }
    
    /**
     * Act method for Bird
     */
    public void act() 
    {
        move (speed);
        checkRemove();
    }   
    
    public void setSpeed(int s)
    {
        speed += s;
    }
}
