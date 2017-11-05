import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hiker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkierBuild extends ScrollingActor
{
    /**
     * Act - do whatever the Hiker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        
    private int speedX = 1;
    private static final int SPEED = 2;
    private static final int BOUNDARY = 40;
    public void act(){
        handleKeyPresses();
        boundedMove();
        
        
    }

    private void handleKeyPresses() {
        handleArrowKey("left", -SPEED);
        handleArrowKey("right", SPEED);
    }

    private void handleArrowKey(String k, int sX) {
        if( Greenfoot.isKeyDown(k) ) {
            speedX = sX;
        }
    }

    private void boundedMove() {
        if( speedX+getX() <= BOUNDARY ) {
            setLocation(BOUNDARY, getY());
            ((BuildWorld)getWorld()).shiftWorld(-speedX);
        } else if( speedX+getX() >= getWorld().getWidth()-BOUNDARY ) {
            setLocation(getWorld().getWidth()-BOUNDARY, getY());
            ((BuildWorld)getWorld()).shiftWorld(-speedX);
        } else {
            setLocation(getX()+speedX, getY());
        }
        speedX = 0;
    }
}
