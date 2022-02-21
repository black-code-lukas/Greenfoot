import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wombat extends Actor
{ 
     /**
      * Act - do whatever the wombat wants to do. This method is called whenever
      * the 'Act' or 'Run' button gets pressed in the environment.
      */
   public wombat ()
   {
       
    }
   
   public void act() 
     {
         checkKeypress (); // Add your action code here.
     } 
    
   public void checkKeypress()
   {
       if (Greenfoot.isKeyDown ("a"))
       {
           move(-10);
       }
        if (Greenfoot.isKeyDown ("d"))
       {
           move(10);
       }
    }
}
