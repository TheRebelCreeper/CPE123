import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class PlayerHitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHitbox extends Hitbox
{ 
    public PlayerHitbox(Actor a, int w, int h, int x, int y, boolean visible)
    {
        super(a, w, h, x, y, visible);
    }
    
    /**
     * Act - do whatever the PlayerHitbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (host.getWorld() != null)
        {
            setLocation(host.getX() + offsetX, host.getY() + offsetY);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }   
}
