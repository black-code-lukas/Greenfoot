import greenfoot.*;

/**
 * Herbst. Eine Welt mit einigen Blättern.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class MyWorld extends World
{
    /**
     * Erzeugt die Welt und die Objekte darin.
     */
    public MyWorld()
    {    
        super(600, 400, 1);
        setUp();
    }
    
    /**
     * Erzeugt die Anfangsobjekte in der Welt.
     */
    private void setUp()
    {
        addObject(new Block(), 300, 200);
        int i=0;
        while (i<12){
            addObject (new Leaf(),Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400)) ;
            i++;
        }
        
        int l=0;
        while (l<8){
            addObject (new Apple(),Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400)) ;
            l++;
        }
        
        }
}

