import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GarpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GarpWorld extends World
{
    private GreenfootSound sound;
    private EndScore endScore;
    Counter counter;

    /**
     * Constructor for objects of class GarpWorld.
     * 
     */
    public GarpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        populateTheWorld();
        

    }

    private void populateTheWorld() {
        addObject(new Garp(), 350, 250);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(670) +15, 
            Greenfoot.getRandomNumber(470) + 15);
        for (int i = 0; i < 10; i++) {
            addObject(new Diamond(), Greenfoot.getRandomNumber(670) +15, 
                Greenfoot.getRandomNumber(470) + 15);
        }
        for (int i = 0; i < 6; i++) {
            addObject(new Rock(), Greenfoot.getRandomNumber(670) +15, 
                Greenfoot.getRandomNumber(470) + 15);
        }
        for (int i = 0; i < 4; i++) {
            addObject(new Bomb(), Greenfoot.getRandomNumber(670) + 15, 
                Greenfoot.getRandomNumber(470) + 15);
        }
        counter = new Counter();
        /* Positionering counter: Omdat Greenfoot met de helft van de afbeelding rekent, 
         * delen we de hoogte en breedte van de afbeelding door twee. We nemen 2 pixels marge. 
         */ 
        int regel = getHeight() - counter.getImage().getHeight() / 2 - 2;
        int kolom = counter.getImage().getWidth() / 2 + 2;
        addObject(counter, kolom, regel);
        setPaintOrder(EndScore.class, Counter.class, Garp.class, Gnomus.class, Diamond.class, Bomb.class, Rock.class);
        sound = new GreenfootSound("gowiththeflow.mp3");
        sound.setVolume(50);
        endScore = new EndScore();

    }
    public void started() {
        sound.playLoop();
    }

    public void stopped() {
        sound.stop();
        endScore.setEndImage(counter.getScore());
        addObject(endScore, getWidth() / 2, getHeight() / 2);
    }
    
    
}


