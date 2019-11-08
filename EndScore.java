import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;

/**
 * Write a description of class EndScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScore extends Score
{
    private long startTime;

    public EndScore() {
        startTime = System.currentTimeMillis();

    }

    /**
     * Act - do whatever the EndScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    public String getElapsedTime() {
        int uren, minuten, seconden;
        long duration = System.currentTimeMillis() - startTime;
        seconden = (int)(duration / 1000);
        uren = seconden / 3600;
        seconden %= 3600;
        minuten = (int) (seconden / 60);
        seconden %= 60;
        return String.format("Duur van het spel: %02d:%02d:%02d", uren, minuten, seconden);

    }

    public void setEndImage(int score) {
        GreenfootImage image;
        String tekst, resultaat;
        Dimension dim;
        tekst = "             EINDE SPEL\n";

        if(score == 10) {
            resultaat = "You won!";
        }
        else {
            resultaat = "You lost!";
        }
        tekst += resultaat + "\n";
        tekst += getElapsedTime() + "\n";
        tekst += "aantal diamanten: " + score + "\n";
        image= new GreenfootImage(10, 10);

        Font font = new Font(" Calibri", true, false, 20);
        image.setFont(font);

        dim = getTextDimensions(image, tekst);
        dim.height *= 8;

        image.scale(dim.width, dim.height);

        image.setColor(new Color(255, 255, 255, 128));
        image.fillRect(0, 0, dim.width, dim.height);
        image.setColor(new Color(128, 128, 128, 128));
        image.fillRect(0, 4, 4, dim.height);
        image.fillRect(4, dim.height - 4, dim.width - 8, dim.height - 4);

        setImage(image);
        image.setColor(new Color(100, 100, 255));
        image.drawString(tekst, dim.width / 8, 20);
    }
}
