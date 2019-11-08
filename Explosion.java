import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private GreenfootImage[] images;
    private GreenfootImage baseImage;
    private int action;
    private int increment;
    private GreenfootSound sound;
    private boolean geluid;
    
    public Explosion() {
        action = 0;
        increment = 1;
        
        images = new GreenfootImage[8];
        baseImage = new GreenfootImage("explosion.png");
        int baseSize = baseImage.getWidth();
        int verschil = baseSize / 8;
        int size = 0;
        for (int i = 0; i < images.length; i++) {
            size += verschil;
            images[i] = new GreenfootImage(baseImage);
            images[i].scale(size, size);
        }
        sound = new GreenfootSound("Booms2.mp3");
        geluid = true;
    }
    
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {  
        if (geluid) {
            sound.play();
            geluid = false;
        }
        setImage(images[action]);
        action += increment;
        if (action > 7) {
            increment = -1;
            action += increment;
        }
        if (action < 0) {
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }    
}
