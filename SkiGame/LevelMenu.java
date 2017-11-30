import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelMenu extends World
{
    private final int LEVEL_NUMBER = 5;
    private LevelButton[] button = new LevelButton[LEVEL_NUMBER];
    private static Star[] star = new Star[5];
    private int starPos[] = {51, 160, 272, 389, 501};
    
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public LevelMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(568, 400, 1); 
        setBackground("LevelSelect.png");
        for (int i = 0; i < LEVEL_NUMBER; i++)
        {
            button[i] = new LevelButton(i + 1);
            addObject(button[i], i * (getWidth() / LEVEL_NUMBER) + 57, 200);
        }
    }
    
    public void setStar(int i)
    {
        star[i - 1] = new Star(i);
        for (int j = 0; j < LEVEL_NUMBER; j++)
        {
            if (star[j] != null)
                addObject(star[j], starPos[j], 300);
        }
    }
    
    public boolean isLocked(int i)
    {
        if (i == 1)
        {
            return false;
        }
        else
        {
            return (star[i - 2] == null);
        }   
    }
}
