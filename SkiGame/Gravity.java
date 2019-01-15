/**
 * Write a description of class Gravity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Gravity
{
    public static final double GRAVITY_ACCEL = 1.5;
    public static final double MAX_GRAV = 10.0;

    /**
     * Causes the player to fall due to gravity if there is empty space below
     */
    public void fall();

    /**
     * Checks if an Actor is at the coordinates passed in
     *
     * @return Returns true if there is an object at the coordinates passed in
     */
    public boolean objectIsBelow();

    /**
     * Determines if the player should fall or not
     */
    public void checkGravity();
}
