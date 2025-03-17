import java.awt.event.*;

public class KeyManager implements KeyListener {
    public boolean up, down, left, right;


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            up = true;
            left = false;
            down = false;
            right = false;
        }
        if(code == KeyEvent.VK_A) {
            up = false;
            left = true;
            down = false;
            right = false;
        }
        if(code == KeyEvent.VK_S) {
            up = false;
            left = false;
            down = true;
            right = false;
        }
        if(code == KeyEvent.VK_D) {
            up = false;
            left = false;
            down = false;
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
