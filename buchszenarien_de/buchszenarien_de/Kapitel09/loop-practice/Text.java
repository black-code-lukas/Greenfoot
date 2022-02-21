import greenfoot.*;
import java.awt.Color;

/**
 * Ein Objekt, das ein wenig Text anzeigt.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Text extends Actor
{
    public Text(String text)
    {
        GreenfootImage img = new GreenfootImage(text, 64, Color.WHITE, null);
        setImage(img);
    }
}
