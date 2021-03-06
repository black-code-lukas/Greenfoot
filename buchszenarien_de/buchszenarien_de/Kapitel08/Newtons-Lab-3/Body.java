import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Ein 'K?rper' ist jede Art von Objekt im Weltall, das eine Masse hat. Es kann ein Stern,  
 * ein Planet oder irgendetwas anderes sein, das im Weltall herumfliegt.
 * 
 * @author Michael K?lling 
 * @version 1.2
 */
public class Body extends SmoothMover
{
    private static final double GRAVITY = 7.8;
    private static final Color defaultColor = new Color(255, 216, 0);
    
    private double mass;
    
    /**
     * Erzeugt ein Body-Objekt mit Standardgr??e, -masse, 
     * -geschwindigkeit und -farbe.
     */
    public Body()
    {
        this (20, 300, new Vector(0, 0.0), defaultColor);
    }
    
    /**
     * Erzeugt ein Body-Objekt der angegebenen Gr??e, Masse, Geschwindigkeit 
     * und Farbe.
     */
    public Body(int size, double mass, Vector velocity, Color color)
    {
        this.mass = mass;
        addToVelocity(velocity);
        GreenfootImage image = new GreenfootImage (size, size);
        image.setColor (color);
        image.fillOval (0, 0, size-1, size-1);
        setImage (image);
    }
    
    /**
     * Agiert. Das hei?t: Wendet die Gravitationskr?fte von allen 
     * anderen vorhandenen K?rpern an und bewegt sich anschlie?end.
     */
    public void act() 
    {
        applyForces();
        move();
        bounceAtEdge();
    }
    
    /**
     * Pr?ft, ob wir auf den Rand des Universums gesto?en sind. Wenn ja, wird abgeprallt.
     */
    private void bounceAtEdge()
    {        
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            
            setLocation((double)getX(), (double)getY());
            invertHorizontalVelocity();
            accelerate(0.9);
        }
        else if (getY() == 0 || getY() == getWorld().getHeight()-1) {
            new Color(Greenfoot.getRandomNumber(300),Greenfoot.getRandomNumber(300),Greenfoot.getRandomNumber(300) );
            setLocation((double)getX(), (double)getY());
            invertVerticalVelocity();
            accelerate(0.9);
        }
    }
    
    /**
     * Wendet die Anziehungskr?fte aller anderen Himmelsk?rper in diesem Universum an.
     */
    private void applyForces()
    {
        List<Body> bodies = getWorld().getObjects(Body.class);
        
        for (Body body : bodies) 
        {
            if (body != this) 
            {
                applyGravity(body);
            }
        }
        
        // stellt sicher, dass wir nicht zu schnell werden: Wenn die aktuelle Geschwindigkeit zu hoch ist, wird etwas abgebremst.
        if (getSpeed() > 6) 
        {
            accelerate (0.9);  // Beschleunigung mit einem Faktor < 1 ist eigentlich eine Verlangsamung.
        }
    }
    
    /**
     * Wendet die Anziehungskraft eines gegebenen K?rpers auf diesen an. 
     * (Kraft wird eine Zeiteinheit lang angewandt; dt==1.)
     */
    private void applyGravity(Body other)
    {
        double dx = other.getExactX() - this.getExactX();
        double dy = other.getExactY() - this.getExactY();
        Vector dv = new Vector (dx, dy); //setzt Richtung korrekt; L?nge immer noch fehlerhaft
        double distance = Math.sqrt (dx*dx + dy*dy);
        double force = GRAVITY * this.mass * other.mass / (distance * distance);
        double acceleration = force / this.mass;
        dv.setLength (acceleration);
        addToVelocity (dv);
    }
    
    /**
     * Liefert die Masse dieses K?rpers zur?ck.
     */
    public double getMass()
    {
        return mass;
    }
}
