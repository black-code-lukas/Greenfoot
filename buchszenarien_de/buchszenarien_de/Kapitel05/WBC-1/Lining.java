import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Die Objekte für die Wandverkleidung - Lining - sind Objekte an den Rändern der Vene. 
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Lining extends Actor
{
    /**
     * Aktion sich am Rand bewegen, um es so aussehen zu lassen, als würde sich die weiße Zelle bewegen.
     * entfernt sich wenn es am Rand anstößt.
     */
    public void act() 
    {
        setLocation(getX()-1, getY());
        if(getX() ==0)
        {
            getWorld().removeObject(this);
            
        }
    }    
}
