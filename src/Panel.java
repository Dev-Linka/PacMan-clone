import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Panel extends JPanel implements Runnable {

    final int TILES = 8; // Tile size in pixels
    final int SCALE = 3; // Scale factor

    public final int TILESIZE = TILES * SCALE; // 24 pixels per tile
    final int MAXSCREENCOL = 224 / TILES; // 28 columns
    final int MAXSCREENROW = 248 / TILES; // 31 rows

    public final int SCREENWIDTH = TILESIZE * MAXSCREENCOL; 
    public final int SCREENHEIGHT = TILESIZE * MAXSCREENROW;

    final int FPS = 120; // 60 FPS


    KeyManager keyHandler = new KeyManager();
    private Thread gameThread;

    int characterX = 100;
    int characterY = 120;
    int characterSpeed = 4;

    CollisionManager collisionManager = new CollisionManager(this);
    Player player = new Player(this, keyHandler, characterX, characterY, characterSpeed);
<<<<<<< HEAD
    Ghost ghost = new Ghost(this, MAXSCREENCOL, characterY, 3);


=======
    Image background;
    Tile tile;
>>>>>>> 2c3b511156f90539b0009e957cb84721cbfcca1c

    public Panel() {
        this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler); // aggiunge il keyHandler al pannello
        this.setFocusable(true); // rende il pannello focusabile
        this.requestFocusInWindow();
        background = new ImageIcon(getClass().getResource("/background.png")).getImage();
        tile = new Tile();
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
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        //g.setColor(Color.BLUE);
        //g.drawRect(60, 60, 72, 48); // 16h x 24w tutti i valori per 3 che è la scala
        Graphics2D g2 = (Graphics2D) g; // cast a Graphics2D

        player.draw(g2);
        ghost.draw(g2);

        g2.dispose(); // rilascia le risorse di sistema utilizzate da Graphics2D

    }



    
}
