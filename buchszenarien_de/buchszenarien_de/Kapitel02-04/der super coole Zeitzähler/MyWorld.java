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
    private int actTimer;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showTime();
    }
    
    public void act()
    {       
       Timer();
       Stop();
    }    
    
    public void showTime()
    {
        showText("Zeit : "+time,300,200);
    }
    
    private void Timer()
    {
       if(actTimer==20){
            time=time+1;
            showTime();
            actTimer=0;
       } 
       actTimer++;
    } 
    
    private void Stop()
    {
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.stop();
        }   
    }
}
