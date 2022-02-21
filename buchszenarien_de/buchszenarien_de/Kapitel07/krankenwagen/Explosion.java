import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    public static int LEBENSDAUER = 50;
    public int lebensdauer = 0;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (lebensdauer <= LEBENSDAUER) {
            lebensdauer ++;
        }
        else {
            getWorld().addObject(new Unfall(),getX(),getY());            
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }    
}
