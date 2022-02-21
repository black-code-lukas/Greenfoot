import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Krankenwagen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Krankenwagen extends Actor
{
    private int speed = 6;
    /**
     * Act - do whatever the Krankenwagen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeypress();
        touchingAutos();
    }
    
    private void checkKeypress(){
       if(Greenfoot.isKeyDown("right")){
          setLocation(getX()+speed,getY());
       }
       if(Greenfoot.isKeyDown("left")){
          setLocation(getX()-speed,getY());
       }
       if(Greenfoot.isKeyDown("up")){
          Auto.speed2 += 0.1;
       }
       if(Greenfoot.isKeyDown("down")){
          Auto.speed2 -= 0.1;          
       }
    }
    
    public void  touchingAutos(){
        if(isTouching(Auto.class)){
            removeTouching(Auto.class);
            getWorld().addObject(new Explosion(),getX(),getY());
            getWorld().removeObject(this);
        }
    }
}
