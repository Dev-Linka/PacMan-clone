import java.awt.*; 
import java.awt.image.*;

import javax.imageio.ImageIO;

public class Player extends Entity {
    Panel panel;
    KeyManager keyHandler;
    int width=32;
    int height=32;

    public Player(Panel panel, KeyManager keyHandler, int x, int y, int speed) {
        super(x, y, speed, "right");
        this.panel = panel;
        this.keyHandler = keyHandler;

        solidArea = new Rectangle(0, 0, 32, 32); // la hitbox del player
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 32;
        solidArea.height = 32;

        getPlayerSpray();
    }

    public void getPlayerSpray(){
        try {
            super.charUpOpen = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanUpOpen.png"));
            super.charDownOpen = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanDownOpen.png"));
            super.charLeftOpen = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanLeftOpen.png"));
            super.charRightOpen = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanRightOpen.png"));

            super.charUpClose = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanUpClose.png"));
            super.charDownClose = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanDownClose.png"));
            super.charLeftClose = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanLeftClose.png"));
            super.charRightClose = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanRightClose.png"));
        
            super.charClosed = ImageIO.read(getClass().getResourceAsStream("sprites/PacmanClosed.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        int newX = x;
        int newY = y;
    
        if (keyHandler.up) {
            direction = "up";
            newY -= speed;
        } else if (keyHandler.down) {
            direction = "down";
            newY += speed;
        } else if (keyHandler.right) {
            direction = "right";
            newX += speed;
        } else if (keyHandler.left) {
            direction = "left";
            newX -= speed;
        }
    
        // Aggiorna la posizione temporanea della hitbox
        solidArea.setLocation(newX, newY);
    
        // Controlla la collisione
        collisionOn = panel.collisionManager.checkCollision(this);
    
        if (!collisionOn) {
            // Se non c'è collisione, aggiorna la posizione
            x = newX;
            y = newY;
        }
    
        // Gestione dell'animazione
        spriteCounter++;
        if (spriteCounter > 10) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }
    
        // Limiti dello schermo
        if (x < 0) x = 0;
        if (x > panel.SCREENWIDTH - width) x = panel.SCREENWIDTH - width;
        if (y < 0) y = 0;
        if (y > panel.SCREENHEIGHT - height) y = panel.SCREENHEIGHT - height;
    }
    

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(super.x, super.y, panel.TILESIZE, panel.TILESIZE);
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(super.spriteNum == 1){
                    image = charUpOpen;
                }
                if(super.spriteNum == 2){
                    image = charUpClose;
                }
                
            break;
            case "down":
                if(super.spriteNum == 1){
                    image = charDownOpen;
                }
                if(super.spriteNum == 2){
                    image = charDownClose;
                }
                
            break;
            case "right":
                if(super.spriteNum == 1){
                    image = charRightOpen;
                }
                if(super.spriteNum == 2){
                    image = charRightClose;
                }
                
            break;
            case "left":
                if(super.spriteNum == 1){
                    image = charLeftOpen;
                }
                if(super.spriteNum == 2){
                    image = charLeftClose;
                }
                
            break;
            default:
                break;
        }

        g2.drawImage(image, x, y, width, height, null);
    }
}

