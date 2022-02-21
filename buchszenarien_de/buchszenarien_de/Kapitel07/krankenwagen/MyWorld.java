import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int time;
    private int i=0;
    private int autozahl=2000;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 800, 1); 
        addObject(new Krankenwagen(),250,700);
    }
    
    public void act(){
       if(Greenfoot.getRandomNumber(100000)<autozahl){
           addObject(new Auto(),Greenfoot.getRandomNumber(500),0);
       }
       actTime(); 
    }
    
    public void actTime(){
        if(i==25){
            time++;
            autozahl=autozahl+10;
            i=0;
        }
        i++;
    }
}
