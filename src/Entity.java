import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int x;
    public int y;
    public int speed;

    public BufferedImage charUpOpen, charDownOpen, charRightOpen, charLeftOpen;
    public BufferedImage charUpClose, charDownClose, charRightClose, charLeftClose;
    public BufferedImage charClosed;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;

    public Entity(int x, int y, int speed, String direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }

    



    
}
