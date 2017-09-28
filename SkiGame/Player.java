import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @Tony Bone, Ritu Bhalodia, Elena Fowler, Aaron Lampert, Jarod Morris
 * @Beta 0.1
 */
public class Player extends Actor
{
    private final int GRAVITY = 4;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fall();
    }    
    
    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    private void fall()
    {
        boolean found = true;
        int i = 0;
        while (i < GRAVITY || !found)
        {
            if (objectIsBelow(getX(), getY() + i) || isAtEdge())
            {
                found = true;
            }
            i++;
        }
        setLocation(getX(), getY() + (i - 1));
        System.out.println(i);
    }
    
    /**
     * Checks if an Actor is at the coordinates passed in
     * 
     * @param x The X position to check at
     * @param y The Y position to check at
     * @return Returns true if there is an object at the coordinates passed in
     */
    private boolean objectIsBelow(int x, int y)
    {
        //if (objectExists())
        //{
        //    return true;
        //}
        //else
        //{
            return false;
        //}
    }
}
