import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class StartingLettering here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartingLettering extends Actor
{
    /**
     * Act - do whatever the StartingLettering wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 300;
    
    /**
     * Erzeugt zum Testen eine Anzeigetafel mit Platzhalterwerten.
     */
    public StartingLettering()
    {
        this(100);
    }

    /**
     * Erzeugt eine Anzeigetafel für das endgültige Ergebnis.
     */
    public StartingLettering(int score)
    {
        makeImage("to start the game", "please click:",2 );
    }

    /**
     * Erzeugt das Bild der Anzeigetafel.
     */
    private void makeImage(String title, String prefix, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(255,255,255, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(20, 20, 20, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title, 60, 100);
        image.drawString(prefix + score, 60, 200);
        setImage(image);
    }
 }
