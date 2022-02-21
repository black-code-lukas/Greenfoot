import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    private int speed;
    
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Apple(){
       speed = Greenfoot.getRandomNumber(3) + 1; 
    }
    
    public void act() 
    {
             if (isAtEdge()) 
        {
            turn(180);
        }
        move(speed);
    }
    
    
}
