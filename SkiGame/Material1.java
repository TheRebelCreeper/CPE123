import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Material1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Material1 extends Material
{
    private GreenfootImage myImage;
    private int speed;
    
    public Material1()
    {
        super();
        myImage = new GreenfootImage("Material1.png");
        setImage(myImage);
        speed = -6;
        setRotation(10);
        part = new Buildable();
    }
    
    /**
     * Act - do whatever the Material1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move (speed);
       checkRemove(); // Add your action code here.
    }    
    
    /**
     * setSpeed - Sets the speed
     * 
     * @param int Value to increase speed by
     */
    public void setSpeed(int s)
    {
        speed += s;
    }
}
