import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ball extends Actor
{
    int x=0;
    double vx = 1;
    double vy = 1;
    double currentSpeed = 5.0;
    
    public ball()
    {
        turn(Greenfoot.getRandomNumber(720)-360);
        newTurn(0.3);
    }
    
    /**
     * Act - do whatever the ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnatEdge();
        setLocation(getX() + (int)vx, getY() + (int)vy);
        //move(4+x);
        hitKangaroo();
        hitwombat();
        goals();
    }
    
    void newTurn(double a) {
        double na = a / (2 * Math.PI) * 180.0;
        vx = Math.cos(na) * currentSpeed;
        vy = Math.sin(na) * currentSpeed;
    }
    
    private void goals()
    {
        if(getY()==0){
            Greenfoot.stop();
            MyWorld myworld =(MyWorld)getWorld();
            myworld.addGoals(1);
            getWorld().addObject(new ball(),300,400);
            getWorld().removeObject(this);
        }
        if(getY()==800){
            Greenfoot.stop();
            MyWorld myworld =(MyWorld)getWorld();
            myworld.addGoals2(1);
            getWorld().addObject(new ball(),300,400);
            getWorld().removeObject(this) ;          
        }
    }
    
    public void hitKangaroo()
    {
        if(isTouching(kangaroo.class))
        {
            if (getX() >= getWorld().getWidth() || getX() <= 0) vx /= -1.0;
        }
        
    }
    
     public void hitwombat()
    {
        if(isTouching(wombat.class))
        {
           if (getX() >= getWorld().getWidth() || getX() <= 0) vx /= -1.0;
        }
        
    }
    
    public void turnatEdge()
    {
        /*if ( isAtEdge() ) 
        {
            turn(Greenfoot.getRandomNumber(40)+80);
        }*/
        if (getX() >= getWorld().getWidth() || getX() <= 0) vx *= -1.0;
    }
    
}
