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
    
    /**
     * Constructor for objects of class MainMenu.
     * 
     */
    public LevelMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(568, 400, 1); 
        setBackground("LevelSelect.png");
        BuildWorld b = new BuildWorld();
        for (int i = 0; i < LEVEL_NUMBER; i++)
        {
            button[i] = new LevelButton(i + 1);
            addObject(button[i], i * (getWidth() / LEVEL_NUMBER) + 50, 200);
        }
    }
}
