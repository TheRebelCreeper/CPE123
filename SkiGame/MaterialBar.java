import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MaterialBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MaterialBar extends Actor
{
    int mbhealth;
    int MaterialBarWidth= 80;
    int MaterialBarHeight= 15;
    int pixelsPerHealthPoint; 
    
    /**
     * Act - do whatever the MaterialBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        update();
    }    
    
    public MaterialBar()
    {
        
    }
   
    public void update()
    {
        setImage(new GreenfootImage(MaterialBarWidth +2, MaterialBarHeight +2));
        GreenfootImage myImage =getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, MaterialBarWidth +1, MaterialBarHeight +1);
        myImage.setColor(Color.GREEN);
        myImage.fillRect(1, 1, mbhealth*pixelsPerHealthPoint, MaterialBarHeight);
        //setImage(myImage);
    }
    
    public void loseHealth()
    {
        mbhealth--;
    }
    
    public void setHealth(int L)
    {
        mbhealth = 4 + (L - 1);
        pixelsPerHealthPoint = (int)MaterialBarWidth/mbhealth;
        
    }
}
