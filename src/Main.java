import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

import components.*;

public class Main extends JFrame{
    static JFrame frame = new JFrame("Frame");
    public static void main(String[] args) {
        makeframe();
        paint(10,10,30,30);
    }

    public static void makeframe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(375, 300));
        frame.getContentPane().add(emptyLabel , BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true); 
    }

        // draw oval 
    public static void paint(int x,int y,int XSIZE,int YSIZE) {
        Graphics g = frame.getGraphics();
        g.setColor(Color.red);
        g.fillOval(x, y, XSIZE, YSIZE);
        g.dispose(); 
    }
}
