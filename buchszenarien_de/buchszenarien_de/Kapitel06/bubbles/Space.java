import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.awt.Color;

/**
 * Ein wenig leerer Raum, in dem die Blasen schweben können.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Space extends World
{
    /**
     * Erzeugt schwarzen Raum.
     */
    public Space()
    {
        super(900, 600, 1);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        setup();
    }
    
    private void setup(){
        addObject(new Bubble(),450,300);
        
    }
}
