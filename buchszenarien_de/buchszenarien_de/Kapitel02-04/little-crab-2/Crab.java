import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)

/**
 * Diese Klasse definiert eine Krabbe. Krabben leben am Strand.
 * 
 * Version: 2
 * 
 * In dieser Version läuft die Krabbe mehr oder weniger zufällig am Strand herum.
 */
public class Crab extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int wormseaten =0;
    private int moving =3;
    private int actTimer =0;
    public Crab()
    {
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);
    }
    /** 
     *  Tut, was auch immer Krabben gerne tun. Diese Methode wird immer dann aufgerufen,
     *  wenn die Buttons 'Act' oder 'Run' in der Entwicklungsumgebung gedrückt werden.
     */
    public void act()
    {
        if(moving==3)
        {
           if(getImage()==image1)
           {
               setImage(image2);
           }
           else
           {
               setImage(image1);
           }
           moving=0;
        }
        move(-5);
        checkKeypress();
        lookForWorm();
        moving=moving+1;
        actTimer= actTimer+1;
    }
    
    public void checkKeypress()
    {
       if (Greenfoot.isKeyDown ("left"))
       {
           turn(-4);
       }
        if (Greenfoot.isKeyDown ("right"))
       {
           turn(4);
       }
    }

    /** 
     * Prüft, ob wir auf einen Wurm gestoßen sind.
     * Wenn ja, wird er gefressen. Wenn nein, passiert nichts.
     */
    
    public void lookForWorm ()
    {
        if ( isTouching(Worm.class))
        {
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
            wormseaten=wormseaten+1;
            CrabWorld crabworld =(CrabWorld)getWorld();
            crabworld.addScore(1);
            if(wormseaten==9)
            {
                Greenfoot.playSound("fanfare.wav");
                Greenfoot.stop();
            }
        }
    }
}