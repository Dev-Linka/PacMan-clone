import javax.swing.JFrame;

public class JFrameWindow extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pac-Man");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}