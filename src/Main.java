import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("pac-man");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setVisible(true); 
        window.setResizable(false);

        Panel panel = new Panel();
        window.add(panel);
        window.addKeyListener(panel.keyHandler);

        window.pack(); // resize the window to fit the preferred size of its components

        panel.startGameThread();

        SoundManager.stopSound("chomp");       
    }
}
