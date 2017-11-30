import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelButton extends Actor
{
    private int level;
    
    public LevelButton(int level)
    {
        this.level = level;
        setImage("SKIButtonLevelSelect.png");
    }
    
    /**
     * Act - do whatever the LevelButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (((LevelMenu)getWorld()).isLocked(level))
        {
            GreenfootImage i = getImage();
            i.setTransparency(128);
            setImage(i);
        }
        
        if (Greenfoot.mouseClicked(this) && !((LevelMenu)getWorld()).isLocked(level))
        {
            SkiWorld.setLevel(level);
            Greenfoot.setWorld(new SkiWorld());
        }
    }    
}
