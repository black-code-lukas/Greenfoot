import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Erzeugt die Krabbenwelt (den Strand). Unsere Welt hat eine Größe 
     * von 560x560 Zellen, wobei jede Zelle nur ein Pixel groß ist.
     */
    public static int WIDTH = 560;
    public static int HEIGHT = 560;
    private int score;
    
    public CrabWorld() 
    {
        super (WIDTH, HEIGHT,1);
        Crab myCrab =new Crab();
        showScore();
        prepare();
    }
    
    private void showScore()
    {
        showText("Score:"+score,420,60);
    }
    
    public void addScore(int points)
    {
        score=score + points;
        showScore();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crab crab = new Crab();
        addObject(crab,251,256);
        Lobster lobster = new Lobster();
        addObject(lobster,310,444);
        Lobster lobster2 = new Lobster();
        addObject(lobster2,110,365);
        Lobster lobster3 = new Lobster();
        addObject(lobster3,199,104);
        Worm worm = new Worm();
        addObject(worm,506,193);
        Worm worm2 = new Worm();
        addObject(worm2,486,313);
        Worm worm3 = new Worm();
        addObject(worm3,221,342);
        Worm worm4 = new Worm();
        addObject(worm4,64,263);
        Worm worm5 = new Worm();
        addObject(worm5,83,522);
        Worm worm6 = new Worm();
        addObject(worm6,397,136);
        Worm worm7 = new Worm();
        addObject(worm7,169,146);
        Worm worm8 = new Worm();
        addObject(worm8,465,474);
        Worm worm9 = new Worm();
        addObject(worm9,253,463);
        Worm worm10 = new Worm();
        addObject(worm10,390,262);
        Worm worm11 = new Worm();
        addObject(worm11,54,64);
        Worm worm12 = new Worm();
        addObject(worm12,514,80);
        lobster.setLocation(405,467);
        lobster3.setLocation(342,83);
        lobster2.setLocation(128,438);
        lobster2.setLocation(148,421);
        lobster.setLocation(441,486);
        worm8.setLocation(447,430);
        worm10.setLocation(339,353);
        lobster3.setLocation(295,39);
    }
    
}