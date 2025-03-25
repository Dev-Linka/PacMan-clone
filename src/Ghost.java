import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ghost extends Entity{
    int width=48;
    int height=48;
    BufferedImage image;

    Panel panel;

    public Ghost(Panel panel, int x,int y,int speed){
        super(x,y,speed,null);
        this.panel=panel;
        getGhostSpary();
    }

    public void getGhostSpary(){
        try {
            image= ImageIO.read(getClass().getResourceAsStream("sprites/redghost.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        if(image!=null){
            g.drawImage(image,x,y,panel.TILESIZE,panel.TILESIZE, null);
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }


}
