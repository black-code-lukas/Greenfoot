import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)

/**
 * Wombat. Ein Wombat bewegt sich vorwärts, bis es an die Ränder der Welt stößt. 
 * Dann dreht es sich nach links. Findet ein Wombat ein Blatt, so frisst es dieses.
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Actor
{
    private int leavesEaten;

    public Wombat()
    {
        leavesEaten = 0;
    }

    /**
     * Tut, was der Wombat gerade gerne machen möchte.
     */
    public void act()
    {
        if (foundLeaf()) {
            eatLeaf();
        }
        else if (canMove()) {
            move();
        }
        else {
            turnLeft();
        }
    }

    /**
     * Geht einen Schritt vorwärts.
     */
    public void move()
    {
        move(1);
    }
    
    /**
     * Dreht sich um 90 Grad.
     */
    public void turnLeft()
    {
        turn(-90);
    }
       
    /**
     * Prüft, ob in der Zelle, in der wir uns befinden, ein Blatt ist.
     * Liefert "true", falls dort ein Blatt ist, sonst "false".
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        return leaf != null;
    }
    
    /**
     * Frisst ein Blatt (falls eines in unserer Zelle ist).
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if (leaf != null) {
            // frisst das Blatt ...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
        }
    }
    
    /**
     * Legt die Blickrichtung fest. Der Parameter 'direction' muss 
     * innerhalb des Bereichs [0..3] liegen.
     */
    public void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) {
            setRotation(direction * 90);
        }
    }
    
    /**
     * Testet, ob wir uns vorwärts bewegen können. Gibt "true" zurück, wenn dies der Fall ist, sonst "false".
     */
    public boolean canMove()
    {
        int rotation = getRotation();
        int x = getX();
        int y = getY();
        boolean facingEdge = false;
        
        switch (rotation) {
            case 0:
                facingEdge = (x == getWorld().getWidth() - 1);
                break;
            case 90:
                facingEdge = (y == getWorld().getHeight() - 1);
                break;
            case 180:
                facingEdge = (x == 0);
                break;
            case 270:
                facingEdge = (y == 0);
                break;
        }
        
        return !facingEdge;
    }

    /**
     * Ermittelt, wie viele Blätter wir gefressen haben.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
}
