import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable {

    final int TILES = 16; // ogni tile è 16x16 pixel
    final int SCALE = 3; // scala di 3

    final int TILESIZE = TILES * SCALE; // 48 x 28 tile
    final int MAXSCREENCOL = 16; // 16 tile per riga
    final int MAXSCREENROW = 12; // 12 tile per colonna
    final int SCREENWIDTH = TILESIZE * MAXSCREENCOL; // 768 pixel
    final int SCREENHEIGHT = TILESIZE * MAXSCREENROW; // 576 pixel

    final int FPS = 60; // 60 FPS


    KeyManager keyHandler = new KeyManager();
    private Thread gameThread;

    int characterX = 100;
    int characterY = 100;
    int characterSpeed = 4;

    public Panel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler); // aggiunge il keyHandler al pannello
        this.setFocusable(true); // rende il pannello focusabile
    }

    public void startGameThread() { // inizializza il tread e lo avvia
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double interval = 1000000000 / FPS; // intervallo di tempo tra un frame e l'altro
        //double nextDrawTime = System.nanoTime() + interval; // tempo in cui verrà disegnato il prossimo frame
        double delta = 0;
        double currentTime;
        double lastTime = System.nanoTime();
        long timer = 0;
        int drawCount = 0; 




        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / interval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if(keyHandler.up == true){
            characterY -= characterSpeed;
        }else if(keyHandler.down == true){
            characterY += characterSpeed;
        }else if(keyHandler.right == true){
            characterX += characterSpeed;
        }else if(keyHandler.left == true){
            characterX -= characterSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D) g; // cast a Graphics2D
        g2.setColor(Color.white);
        g2.fillRect(characterX, characterY, TILESIZE, TILESIZE);
        g2.dispose(); // rilascia le risorse di sistema utilizzate da Graphics2D

    }



    
}
