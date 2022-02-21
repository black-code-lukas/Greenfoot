import greenfoot.*;  // (World, Actor, GreenfootImage und Greenfoot)

/**
 * Ein Klavier, das mit der Computertastatur gespielt werden kann.
 * 
 * @author: M. Kölling
 * @version: 0.1
 */
public class Piano extends World
{
    private String[] whiteKeys=
    {"a","s","d","f","g","h","j","k","l","ö","ä","#"};
    private String[] whiteNotes=
    {"3c","3d","3e","3f","3g","3a","3b","4c","4d","4e","4f","4g"};
    private String[] blackKeys=
    {"w","e","","t","z","u","","o","p","","+"};
    private String[] blackNotes=
    {"3c#","3d#","","3f#","3g#","3a#","","4c#","4d#","","4f#"};
    
    private Key key;
    /**
     * Erzeugt das Klavier.
     */
    public Piano() 
    {
        super(800, 340, 1);
        makeKeys();
        showTextMessage();                                                              
    }
    
    private void showTextMessage(){
        showText("Klicke 'Run' und nutze die Computertasten zum Spielen",400,301);
    }    
    
    public void makeKeys()
    {
        int i = 0;
        while(i<whiteKeys.length){
            Key key =new Key(whiteKeys[i],whiteNotes[i]+".wav",0);
            addObject( key,i*63+54,140);
            i++;
        }
       
        for(int m = 0;m < blackKeys.length;m++){
              if(! blackKeys[m].equals("")){
              Key key =new Key(blackKeys[m],blackNotes[m]+".wav",1);
              addObject( key,m*63+85,86);
            }
        }
          
    }   
    
}