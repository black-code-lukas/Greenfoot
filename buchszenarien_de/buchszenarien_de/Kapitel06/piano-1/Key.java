import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)

public class Key extends Actor
{
    private boolean isDown; 
    private String key;
    private String sound;
    private int x;
    private String[]keyColour =
    {"white-key.png","black-key.png"};
    private String[]keyDownColour =
    {"white-key-down.png","black-key-down.png"};
    
    /**
     * Erstellt eine neue Taste.
     */
    public Key(String keyName, String soundFile, int xx)
    {
        key =keyName;
        sound = soundFile;
        x=xx;
        setImage(keyColour[x]);
    }

    /**
     * Die Aktion für diese Taste.
     */
    public void act()
    {
        if(!isDown &&Greenfoot.isKeyDown(key)){
            setImage(keyDownColour[x]);
            isDown = true;
            play();
        }
        if(isDown &&!Greenfoot.isKeyDown(key)){
           setImage(keyColour[x]);
           isDown = false;
        }
    }
    
    public void play()
    {
        Greenfoot.playSound(sound);
    }
}