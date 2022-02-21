import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)
import java.awt.Color;

/**
 * Weltraum. Etwas, in dem Raketen fliegen ...
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class Space extends World
{
    /**
     * Erzeugt die Weltraum-Welt mit schwarzem Hintergrund und Sternen.
     */
    public Space() 
    {
        super(950, 700, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        createStars(300);
        Explosion.initialiseImages();
        makeRocket();
        prepare();
    }

    /**
     * Erzeugt einige zufällige Sterne in der Welt.
     */
    private void createStars(int number) 
    {
        GreenfootImage background = getBackground();             
        for (int i=0; i < number; i++) {            
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            int color = 150 - Greenfoot.getRandomNumber(120);
            background.setColorAt(x, y, new Color(color,color,color));
        }
    }

    public void makeRocket(){
        int i=0;
        while(i <1){
            addObject(new Rocket(),475,350);
            i++;
        }
    }

    /**
     * Bereite die Welt für den Programmstart vor. Das heißt: Erzeuge die Anfangs-
     * Objekte und füge sie der Welt hinzu.
     */
    private void prepare()
    {
        Asteroid asteroid = new Asteroid();
        addObject(asteroid,656,146);
        Asteroid asteroid2 = new Asteroid(100);
        addObject(asteroid2,863,271);
        Asteroid asteroid3 = new Asteroid(200);
        addObject(asteroid3,231,200);
        Asteroid asteroid4 = new Asteroid();
        addObject(asteroid4,776,507);
        Asteroid asteroid5 = new Asteroid();
        addObject(asteroid5,573,558);
        Asteroid asteroid6 = new Asteroid(100);
        addObject(asteroid6,310,535);
    }
}
