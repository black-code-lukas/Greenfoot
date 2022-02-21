import greenfoot.*;

/**
 * Eine Rakete, die durch die Pfeiltasten Auf, Links und Rechts gesteuert wird.
 * Die Rakete feuert durch Drücken der Leertaste. 'z' löst eine Protonenwelle aus.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;         // Die minimale Verzögerung zwischen den Schüssen.

    private int reloadDelayCount;               // Zeitspanne seit dem letzten Schuss.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initialisiert diese Rakete.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        addToVelocity(new Vector(10, 0.7));
    }

    /**
     * Tut, was eine Rakete tun muss. (Das heißt: meistens Herumfliegen und Wenden,
     * Beschleunigen und Schießen, wenn die entsprechenden Tasten gedrückt werden.)
     */
    public void act()
    {
        checkKeys();
        move();
        reloadDelayCount++;
        checkCollision();
    }
    
    /**
     * Prüft, ob irgendeine Taste gedrückt wurde, und reagiert darauf.
     */
    private void checkKeys() 
    {
        ignite(Greenfoot.isKeyDown("up"));
        if (Greenfoot.isKeyDown("left")){
            int rotation = getRotation()-6;
            setRotation(rotation);
        }
         if (Greenfoot.isKeyDown("right")){
            int rotation = getRotation()+6;
            setRotation(rotation);
        }
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
    }
    
    private void ignite(boolean boosterOn){
       if(boosterOn){
          setImage("rocketWithThrust.png");
          addToVelocity(new Vector(getRotation(), 0.4));
       }
       else{
          setImage(rocket) ;
       }
    }
    
    /**
     * Feuert eine Kugel, wenn die Waffe bereit ist.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getVelocity(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
      
    private void checkCollision(){
        Asteroid a = (Asteroid) getOneIntersectingObject(Asteroid.class);
        if(a != null){
            World world =getWorld();
            int x =getX();
            int y =getY();
            Space space =(Space)getWorld();
            space.gameOver();
            world.removeObject(this);            
            world.addObject(new Explosion(),x,y);            
        } 
    }
}
