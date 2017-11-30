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
    boolean isAlive;
    
    public int invincibledelay;
    public int invincibleDELAY = 30;
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
    public void act()
    {
        checkGravity();
        resetAngle();
        poweredUp();
        isTouchingRamp();
        checkCollision();
        checkDie();
        
        checkForShields();
        invincibleDelay();
    }
    
    public boolean objectIsBelow()
    {
        // If it is touching another Actor
        if (getOneObjectAtOffset(0, getImage().getHeight() / 2 + 5, Actor.class) != null)
        {
            Ramp r = (Ramp)getOneObjectAtOffset(0, getImage().getHeight() / 2 + 5, Ramp.class);
            if (r != null && r.getPlaced() == 2)
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
            if (p != null && p.getPlaced() == 2)
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
            Ramp r = (Ramp)getOneIntersectingObject(Ramp.class);
            if (r != null && r.getPlaced() == 2)
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
        if(s != null && ((ShieldBuild) s).getPlaced() == 2)
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
                setImage("skiernormalBuild.png");
                invincible = false;
                invincibledelay = invincibleDELAY;
            }
        }
    }
    
    public void checkDie()
    {
        if(getY() > getWorld().getHeight() + 30)
        {
            SkiWorldOver s = new SkiWorldOver(false);
            Greenfoot.setWorld(s);
        }
    }
}
