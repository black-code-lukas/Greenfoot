import greenfoot.*;

/**
 * Diese Klasse definiert eine Krabbe. Krabben leben am Strand.
 */
public class Crab extends Actor
{
    public void act()
   {if (isAtEdge())
       {   
        turn(45);
       }
    if(Greenfoot.getRandomNumber(100)<20)
     {
         turn(Greenfoot.getRandomNumber(90)-45) ;
     }
     move(5);// Füge hier deinen Code ein.
     if( isTouching(Worms.class))
    {
        removeTouching(Worms.class);
    } 
   }   
}
