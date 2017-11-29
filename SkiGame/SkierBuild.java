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
    
    public int invincibledelay;
    public int invincibleDELAY = 20;
    boolean invincible;
    
    public SkierBuild()
    {
        setImage(new GreenfootImage("skiernormalBuild.png"));
        setRotation(10);
        isAlive = true;
        
        invincible = false;
        invincibledelay = invincibleDELAY;
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
        checkCollision();
        checkDie();
        
        checkForShields();
        invincibleDelay();
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
        if( isTouching(PowerUpBuild.class) )
        {

            

            PowerUpBuild p = (PowerUpBuild)getOneIntersectingObject(PowerUpBuild.class);
            if ( p.getPlaced() == 2)
            {
                removeTouching(PowerUpBuild.class);
                setRotation(-45);
                move(200);
            }

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
        if(o != null && invincible == false)
        {
            isAlive = false;
            setImage("skierhitBuild.png");
        }
    }
    
    public void checkForShields()
    {
        Actor s = getOneIntersectingObject(ShieldBuild.class);
        if(s != null)
        {
            invincible = true;
        }
    }
    
    public void invincibleDelay()
    {
        if(invincible == true)
        {
            invincibledelay--;
            setImage("skiernormalBuildring.png");
            if(invincibledelay <= 0)
            {
                invincible = false;
                setImage("skiernormalBuild.png");
                invincibledelay = invincibleDELAY;
            }
        }
    }
    
    public void checkDie()
    {
        if(getY() > getWorld().getHeight() + 30)
        {
            SkiWorldOver s = new SkiWorldOver();
            Greenfoot.setWorld(s);
        }
    }
}
