import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class BonusManager extends Frame{
    int x, y;
    ArrayList<Image> images = new ArrayList<>();
    ArrayList<String> typeBonus = new ArrayList<>();
    boolean right;

    int height = 48;

    public BonusManager(int x, int y, boolean right){
        this.x = x;
        this.y = y;
        this.right = right; // se vero stampa da destra a sinistra (<--) / se falso (-->)
    }

    public void addBonus(String typeBonus){
        String fileName = "";

        if(typeBonus.equals("life")){
            fileName = "sprites/pacmanRightClose.png";
        }else{
            fileName = "sprites/fruits/"+typeBonus+".png";

        }

        try {
            images.add(ImageIO.read(new File(fileName)));        
            this.typeBonus.add(typeBonus);
        
        } catch (IOException e) {
            System.out.println("Errore nel caricamento immagine: " + e);
        }
    }

    public void addBonus2(String typeBonus[]){ // Da sistemare
        for(int i=0; i<typeBonus.length; i++){
            String typeB = typeBonus[i];
            String fileName = "";

            if(typeB.equals("life")){
                fileName = "sprites/pacmanRightClose.png";
            }else{
                fileName = "sprites/fruits/"+typeB+".png";
            }

            try {
                images.add(ImageIO.read(new File(fileName)));
                this.typeBonus.add(typeB);
            } catch (IOException e) {
                System.out.println("Errore nel caricamento immagine: " + e);
            }
        }
    }

    public void removeBonus(String typeBonus){
        for(int i=0; i<this.typeBonus.size(); i++){
            if(typeBonus.equals(this.typeBonus.get(i))){
                this.typeBonus.remove(i);
                images.remove(i);
                break;
            }
        }
        repaint();
    }

    public void draw(Graphics g){
        if (images != null) {
            int x = this.x;
            for (Image image : images) {               
                g.drawImage(image, x, y, this);
                

                x = x + image.getWidth(getParent()) + 5;


                // if(right)
                //     x = x - image.getWidth(getParent()) + 5;
                // else 
                //     x = x + image.getWidth(getParent()) + 5;
            }
        }
    }
}
