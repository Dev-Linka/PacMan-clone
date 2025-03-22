import java.awt.Graphics;

public class Tile {
    public boolean collision = false;

    public void drawWall(Graphics g){
        g.drawRect(504, 504, 16, 2400); // 16h x 24w
    }
}
