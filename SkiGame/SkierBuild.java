import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hiker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SkierBuild extends SmoothMover implements Gravity
{
    /**Vertical Velocity*/
    private int ySpeed = 0;
    private int speedX = 1;
    private static final int SPEED = 2;
    private static final int BOUNDARY = 40;
    boolean isAlive;
    
    public SkierBuild()
    {
        setImage(new GreenfootImage("skiernormalBuild.png"));
        setRotation(10);
        isAlive = true;
    }
    
    /**
     * Act - do whatever the Hiker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        handleKeyPresses();
        checkGravity();
        resetAngle();
        poweredUp();
        isTouchingRamp();
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
    
    public boolean objectIsBelow()
    {
        // If it is touching another Actor
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 5, Actor.class) != null)
        {
            if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 5, Ramp.class) != null)
            {
                if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 5, Hitbox.class) == null)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
                return true;
        }
        // If it is touching the edge of the world
        else if (getY() >= getWorld().getHeight() - getImage().getHeight())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void fall()
    {
        setLocation(getX(), getY() + ySpeed);

        if( ySpeed <= MAX_GRAV)   // If velocity is less than terminal velocity
        {
            ySpeed += GRAVITY_ACCEL;    // Accelerate
        }
    }
    
    public void checkGravity()
    {
        if (objectIsBelow() && isAlive)    // If object is on solid ground and is alive
        {
            ySpeed = 0;   // Set vertical speed to 0
        }
        else
        {
            fall();
        }
    }
    
     private void resetAngle()
    {
        if (!objectIsBelow())
        {
            if ((getRotation()) < 10 || getRotation() > 180)
            {
                setRotation(getRotation() + 3);
            }
        }
    }
    
    public void poweredUp()
    {
        if( isTouching(Power.class) )
        {
            removeTouching(Power.class);
            setRotation(-45);
            move(200);
        }
    }
    
    private void isTouchingRamp()
    {
        if (isTouching(Hitbox.class))
        {
            setRotation(-18);
        }
    }
    
    public void checkCollision()
    {
        Actor o = getOneIntersectingObject(Obstacle.class);
        if(o != null)
        {
            isAlive = false;
        }
    }
}
