import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Bakterien schwimmen in der Blutbahn. Sie sind bösartig. Am besten vernichtest 
 * du sie, wenn du kannst.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Bacteria extends Actor
{
    private int speed;
    
    /**
     * Konstruktor. Bisher nichts zu tun.
     */
    public Bacteria()
    {
         speed = Greenfoot.getRandomNumber(6)+2;
    }

    /**
     * Schwimmen in der Blutbahn, dabei langsam rotieren. 
     */
    public void act() 
    {
        setLocation(getX()- speed, getY());
        turn(1);
        
        if (getX() == 0) 
        {
            Bloodstream bloodstream =(Bloodstream)getWorld();
            bloodstream.addScore(-15);
            getWorld().removeObject(this);
        }
    }
}
