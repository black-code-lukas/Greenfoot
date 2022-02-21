import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kangaroo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kangaroo extends Actor
{
    /**
     * Act - do whatever the kangaroo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   public void act() 
     {
         checkKeypress (); // Add your action code here.
     } 
    
   public void checkKeypress()
   {
       if (Greenfoot.isKeyDown ("right"))
       {
           move(10);
       }
        if (Greenfoot.isKeyDown ("left"))
       {
           move(-10);
       }
       if (Greenfoot.isKeyDown ("down")){
           
           
        }
       if (Greenfoot.isKeyDown ("up"))
       {
           
       }
        
   }
}