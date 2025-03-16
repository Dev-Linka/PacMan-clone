import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable {

    final int TILES = 16; // ogni tile è 16x16 pixel
    final int SCALE = 3; // scala di 3

    public final int TILESIZE = TILES * SCALE; // 48 x 28 tile
    final int MAXSCREENCOL = 16; // 16 tile per riga
    final int MAXSCREENROW = 12; // 12 tile per colonna
    final int SCREENWIDTH = TILESIZE * MAXSCREENCOL; // 768 pixel
    final int SCREENHEIGHT = TILESIZE * MAXSCREENROW; // 576 pixel

    final int FPS = 120; // 60 FPS


    KeyManager keyHandler = new KeyManager();
    private Thread gameThread;

    int characterX = 100;
    int characterY = 100;
    int characterSpeed = 4;

    Player player = new Player(this, keyHandler, characterX, characterY, characterSpeed);

    public Panel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler); // aggiunge il keyHandler al pannello
        this.setFocusable(true); // rende il pannello focusabile
        this.requestFocusInWindow();
    }

    public void startGameThread() { // inizializza il tread e lo avvia
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
public void run() {
    double interval = 1000000000 / FPS; // Tempo tra i frame
    long lastTime = System.nanoTime();
    
    while (gameThread != null) {
        long currentTime = System.nanoTime();
        double delta = (currentTime - lastTime) / interval;
        
        if (delta >= 1) {
            update();
            repaint();
            lastTime = currentTime;
        }

        try {
            Thread.sleep(5); // Aggiunge una pausa per ridurre il carico della CPU
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D) g; // cast a Graphics2D
        
        g2.dispose(); // rilascia le risorse di sistema utilizzate da Graphics2D

    }



    
}
