import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Hitbox extends Actor
{
    protected GreenfootImage img;
    protected int offsetX;
    protected int offsetY;
    protected Actor host;
    
     public Hitbox(Actor a, int w, int h, int x, int y, boolean visible)
    {
        setRotation(a.getRotation());
        host = a;
        offsetX = x;
        offsetY = y;
        img = new GreenfootImage(w, h);
        if (visible)
        {
            img.setColor(Color.RED);
            img.setTransparency(100);
            img.fill();
        }
        
        setImage(img);
    }
    
    /**
     * Act - do whatever the Hitbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public abstract void act(); 
    
    public List getHitboxIntersections()
    {
        return getIntersectingObjects(Actor.class);
    }
    
    public Actor getOneObjectAtOffsetPublic(int x, int y, java.lang.Class<?> a)
    {
        return getOneObjectAtOffset(x, y, a);
    }
    
    public Actor getOneIntersectingObjectPublic(java.lang.Class<?> cls)
    {
        return getOneIntersectingObject(cls);
    }
}
