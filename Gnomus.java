import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gnomus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gnomus extends Actor
{
    GreenfootSound scream;
    public Gnomus() {
        scream = new GreenfootSound("scream.wav");
        setRotation();
    }

    /**
     * Act - do whatever the Gnomus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //setRotation(0);
        move(5);
        if (atWorldEdge()) {
            move(-5);
            setRotation();
        } else {
            int random = Greenfoot.getRandomNumber(100);
            if (random < 2) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(180));
            } else if (random > 98) {
                setRotation(getRotation() - Greenfoot.getRandomNumber(180));
            }
        }
        lookForGarp();
        lookForActor();

    }
    private void setRotation() {
        if (Greenfoot.getRandomNumber(100) > 50) {
            setRotation(getRotation() + Greenfoot.getRandomNumber(180));
        } else {
            setRotation(getRotation() - Greenfoot.getRandomNumber(180));
        }
    }

    private boolean atWorldEdge() {
        int x = getX();
        int y = getY();
        int i = getImage().getWidth() / 2;
        int wx = getWorld().getWidth() - i;
        int wy = getWorld().getHeight() - i;

        if (x <= i) return true;
        if (y <= i) return true;
        if (x >= wx) return true;
        if (y >= wy) return true;
        return false;
    }

    private void lookForGarp() {
        Actor garp = getOneObjectAtOffset(0, 0, Garp.class);
        if (garp != null) {
            scream.play();
            getWorld().removeObject(garp);
            Greenfoot.stop();
        }

        
    }

    private void lookForActor() {
        Actor actor = getOneObjectAtOffset(0, 0, Actor.class);
        if (actor != null) {           
            turn(45);            
        }

    }
}
