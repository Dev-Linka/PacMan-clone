import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ghost extends Entity{
    int width=48;
    int height=48;
    String color;
    BufferedImage image, p1eR, p2eR, p1eL, p2eL, p1eT, p2eT, p1eB, p2eB;

    Panel panel;

    public Ghost(Panel panel, int x,int y,int speed, String color){
        super(x,y,speed,null);
        this.panel=panel;
        this.color = color;
        getGhostSpary();
    }

    public void getGhostSpary(){
        try {
            // image= ImageIO.read(getClass().getResourceAsStream("sprites/redghost.jpeg"));

            p1eR = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p1eR.png"));
            p2eR = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p2eR.png"));
            p1eL = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p1eL.png"));
            p2eL = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p2eL.png"));
            p1eT = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p1eT.png"));
            p2eT = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p2eT.png"));
            p1eB = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p1eB.png"));
            p2eB = ImageIO.read(getClass().getResourceAsStream("sprites/ghost/"+color+"_p2eB.png"));

            image = p1eR;
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
