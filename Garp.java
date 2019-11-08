import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Garp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor
{
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    private boolean isStart;

    public Garp() {
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");
        setImage(imageRight);
        isStart = true;

    }

    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movingAndTurning();
        collectingDiamonds();
        foundBomb();

    }

    private void movingAndTurning() {
        if (Greenfoot.isKeyDown("right")) {
            if (getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(0);
            move(5);
            if (foundRock()) {
                move(-5);
            }

        }
        if (Greenfoot.isKeyDown("left")) {
            if (getImage() == imageRight) {
                setImage(imageLeft);
            }
            setRotation(0);
            move(-5);
            if (foundRock()) {
                move(5);
            }
        }
        if(Greenfoot.isKeyDown("up")) {
            if (getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(-90);
            move(5);
            if (foundRock()) {
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("down")) {
            if (getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(90);
            move(5);
            if (foundRock()) {
                move(-5);
            }
        }

    }

    private void collectingDiamonds() {
        Actor diamond;
        diamond = getOneObjectAtOffset(0, 0, Diamond.class);
        if (diamond != null) {
            World world = getWorld();
            world.removeObject(diamond);
            List list = world.getObjects(Counter.class);
            Counter counter = (Counter) list.get(0);
            counter.addScore();
            if (counter.getScore() == 10) {
                Greenfoot.stop();
            }

        }
    }    

    private boolean foundRock() {
        Actor rock = getOneObjectAtOffset(0, 0, Rock.class);
        if (rock != null) {
            return true;
        }
        return false;

    }

    private void foundBomb() {
        Actor bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if (bomb != null) {
            getWorld().removeObject(bomb);
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);

        }

    }

}
