import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Auto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Auto extends Actor
{
    private int speed =3;
    private int i=0;
    public static double speed2 = 0;
    /**
     * Act - do whatever the Auto wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {  
        setKrankenwagen(speed);    
        if(i==25){
            newSpeed(speed/2);
            i=0;
        }
        i++;
        if (getY() == 799) 
        {
            getWorld().removeObject(this);
        }
    }  
    
    public void setKrankenwagen(int xspeed){
        setLocation(getX(),getY()+xspeed+((int) speed2));
    }
    
    private void setSpeed(){
        speed=Greenfoot.getRandomNumber(7)-2;
        if(speed==0){
            newSpeed(2);
        }
    }
    
    private void newSpeed(int oldSpeed){        
        speed=Greenfoot.getRandomNumber(12)-4+oldSpeed;
        if(speed==0){
            newSpeed(2);
        }
    }
}
