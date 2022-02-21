import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int goals;
    private int goals2;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 801,1);
        addObjects();
        showGoals();
        showGoals2();
    }
    
    private void addObjects()
    {
        addObject(new ball(),300,400);
        addObject(new kangaroo(),300,720);
        addObject(new wombat(),300,70);
    }
    
    private void showGoals()
    {
        showText("Tore Kangaroo :"+goals,150,70);
    }
    
    private void showGoals2()
    {
        showText("Tore Wombat :"+goals2,450,70);
    }
    
    public void addGoals(int points)
    {
        goals++;
        showGoals();
    }
    
     public void addGoals2(int points)
    {
        goals2++;
        showGoals2();
    }
}
