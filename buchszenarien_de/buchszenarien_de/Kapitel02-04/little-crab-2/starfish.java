import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class starfish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class starfish extends Actor
{
    /**
     * Act - do whatever the starfish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if ( isAtEdge() ) 
        {
            turn(17);
        }

        if ( Greenfoot.getRandomNumber(100) < 10 ) 
        {
            turn( Greenfoot.getRandomNumber(90)-45 );
        }
        move(1);
        killeveryThing();
    }    
    
     public void killeveryThing ()
    {
        if ( isTouching(Crab.class))
        {
            removeTouching(Crab.class);
            Greenfoot.stop();
            Greenfoot.playSound("verloren2.wav");
        }
         if ( isTouching(Lobster.class))
        {
            removeTouching(Lobster.class);
        }
         if ( isTouching(Worm.class))
        {
            removeTouching(Worm.class);
        }
    }
}
