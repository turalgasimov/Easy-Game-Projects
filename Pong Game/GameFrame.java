import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    GamePanel panel;

    GameFrame() {

        panel = new GamePanel();
        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);

        this.pack();
        this.setVisible(true);

        this.setLocationRelativeTo(null);

    }

}