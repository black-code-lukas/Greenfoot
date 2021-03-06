import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Dies ist eine weiße Blutzelle. Diese Zellart hat die Aufgabe, Bakterien   
 * abzufangen und aus dem Blut zu entfernen.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class WhiteCell extends Actor
{
    /**
     * Aktion: auf- und abbewegen, wenn Pfeiltasten gedrückt werden.
     */
    public void act() 
    {
        checkKeyPress();
        checkCollision();
    }
    
    /**
     * Prüft, ob eine Taste auf der Tastatur gedrückt wurde, und
     * reagiert, falls dies zutrifft.     
     */
    private void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY()-8);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+8);
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX()+4, getY());
        }
        
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX()-4, getY());
        }
    }
    
    /**
     * Prüft, ob wir ein Bakterium oder ein Virus berühren. Entfernt Bakterium.
     * Spielende, falls wir ein Virus getroffen haben.
     */
    private void checkCollision()
    {
        if (isTouching(Bacteria.class)) 
        {
            Greenfoot.playSound("slurp.wav");
            removeTouching(Bacteria.class);
            Bloodstream bloodstream = (Bloodstream)getWorld();
            bloodstream.addScore(20);
        }

        if (isTouching(Virus.class)) 
        {
            removeTouching(Virus.class);
            Bloodstream bloodstream = (Bloodstream)getWorld();
            bloodstream.addScore(-100);            
        }
    }
}
