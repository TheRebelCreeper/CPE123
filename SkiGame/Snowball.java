import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snowball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snowball extends Obstacle
{
    /**
     * Act - do whatever the Snowball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Snowball()
    {
        setRotation(10);
        setImage(new GreenfootImage("snowball.png"));
    }
    
    
    public void act() 
    {
        move (-7);
        checkRemove();
        
    }    
    


}
