import java.awt.*;
import javax.swing.*;

public class Player extends Entity {
    Panel panel;
    KeyManager keyHandler;
    int x, y, speed;

    public Player(Panel panel, KeyManager keyHandler, int x, int y, int speed) {
        super(x, y, speed);
        this.panel = panel;
        this.keyHandler = keyHandler;
    }

    public void update() {
        if(keyHandler.up == true){
            y -= speed;
        }else if(keyHandler.down == true){
            y += speed;
        }else if(keyHandler.right == true){
            x += speed;
        }else if(keyHandler.left == true){
            x -= speed;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(x, y, panel.TILESIZE, panel.TILESIZE);
    }
}
