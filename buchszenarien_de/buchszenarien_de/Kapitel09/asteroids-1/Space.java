import greenfoot.*;
import java.awt.Color;

/**
 * Weltraum. Etwas, in dem Raketen herumfliegen können.
 * 
 * @author Michael Kölling
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 4;
    private int finalscore=0;
    private int newworld =0;
    private int end =0;

    /**
     * Erzeugt den Weltraum und alle Objekte darin.
     */
    public Space() 
    {
        super(800, 625, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars(300);
        
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60,600);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        StartingLettering startinglettering =new StartingLettering(2);
        addObject(startinglettering,getWidth()/2,getHeight()/2);
    }
    
    public void act(){
        
         int i=-100;
         while (i<1){          
             if(Greenfoot.isKeyDown("2")) {
               createSpace();
               getObjects(Counter.class);
           }
           i++;
        } 
    }
    
    public void createSpace(){
        if(newworld==0){
           Rocket rocket = new Rocket();
           addObject(rocket, getWidth()/2 + 100, getHeight()/2);        
           addAsteroids(startAsteroids);
           newworld ++;
        }
        else{
        
        }
    }
    
    public void moveObjects(){
    
        while (end>1){
               createSpace();
          }
    }
    
    public void createStars(int number){
       GreenfootImage background = getBackground();
       for (int i=0;i < number;i++ ){
           int x = Greenfoot.getRandomNumber(getWidth());
           int y = Greenfoot.getRandomNumber(getHeight());
           int color = 120 - Greenfoot.getRandomNumber(100);
           background.setColor(new Color(color,color,color)); 
           background.fillOval(x, y, 2, 2);
       }
       
        for (int i=0;i < number/20;i++ ){
           int x = Greenfoot.getRandomNumber(getWidth());
           int y = Greenfoot.getRandomNumber(getHeight());
           int color = 180 - Greenfoot.getRandomNumber(100);
           background.setColor(new Color(color,color,color)); 
           background.fillOval(x, y, 2, 2);
       }
    }
    
    /**
     * Fügt eine vorgegebene Anzahl an Asteroiden in unsere Welt. Asteroiden werden nur
     * in die linke Hälfte der Welt eingefügt.
     */
    private void addAsteroids(int count) 
    {       
        for( int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
           
        }
    }
    
    /**
     * Diese Methode wird aufgerufen, wenn das Spiel zu Ende ist, um den Endstand anzuzeigen.
     */
    public void gameOver() 
    {
        countScore(0);
        ScoreBoard scoreboard =new ScoreBoard(finalscore);
        addObject(scoreboard,getWidth()/2,getHeight()/2);
    }
    
    public void countScore(int score){
        getObjects(Counter.class).get(0).add(score);
        if (score>0){
            finalscore+=score;
        }
    }

}
