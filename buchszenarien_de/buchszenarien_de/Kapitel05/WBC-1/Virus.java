import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus extends Actor
{
    private int speed;
    
    public Virus ()
    {
        speed = Greenfoot.getRandomNumber(5)+1;
    }
    /**
     * Bewegt den Virus in der Blutbahn. Dreht den Körper gegen den Urzeigersinn
     * Entferntden Körper, wenn er am linken Rand ankommt. 
     */
    public void act() 
    {
        setLocation(getX()-speed,getY());
        turn(-1);
         if (getX() == 0) 
        {
            getWorld().removeObject(this);
        }
    }    
}
