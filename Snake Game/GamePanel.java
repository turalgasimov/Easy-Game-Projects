import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static  final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    int bodyParts = 2;

    int applesEaten;
    int appleX;
    int appleY;

    static char direction = 'R';

    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {

        random = new Random();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        startGame();

    }

    public void startGame() {

        newApple();

        running = true;
        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g) {

        if (running) {

            for (int i = 0; i < bodyParts; i++) {

                if (i == 0) {

                    g.setColor(Color.white);

                } else {

                    g.setColor(Color.yellow);

                }

                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

            }

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            g.setFont(new Font("Ink Free", Font.BOLD, 75));

            FontMetrics metrics1 = getFontMetrics(g.getFont());

            g.drawString("Score: "+applesEaten, (SCREEN_WIDTH-metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());

        } else gameOver(g);

    }

    public void newApple() {

        appleX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

    }

    public void move() {

        for (int i = bodyParts; i > 0; i--) {

            x[i] = x[i-1];
            y[i] = y[i-1];

        }

        switch (direction) {

            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;

        }

    }

    public void checkApple() {

        if ((x[0] == appleX) && (y[0] == appleY)) {

            bodyParts++;
            applesEaten++;
            newApple();

        }

    }

    public void checkCollisions() {

        for (int i = bodyParts; i > 0; i--) {

            if ((x[0] == x[i]) && (y[0] == y[i])) {

                running = false;
                break;

            }

        }

        if ((x[0] < 0) || (x[0] >= SCREEN_WIDTH) || (y[0] >= SCREEN_HEIGHT) || (y[0] < 0)) {

            running = false;

        }

        if (!running) {

            timer.stop();

        }

    }

    public void gameOver(Graphics g) {

        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));

        FontMetrics metrics1 = getFontMetrics(g.getFont());

        g.drawString("Score: "+applesEaten, (SCREEN_WIDTH-metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());

        FontMetrics metrics = getFontMetrics(g.getFont());

        g.drawString("GAME OVER!", (SCREEN_WIDTH-metrics.stringWidth("GAME OVER!"))/2, SCREEN_HEIGHT/2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {

            move();
            checkApple();
            checkCollisions();

        }

        repaint();

    }

    public static class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {

                case KeyEvent.VK_LEFT -> {

                    if (direction != 'R') {

                        direction = 'L';

                    }

                }

                case KeyEvent.VK_RIGHT -> {

                    if (direction != 'L') {

                        direction = 'R';

                    }

                }

                case KeyEvent.VK_UP -> {

                    if (direction != 'D') {

                        direction = 'U';

                    }

                }

                case KeyEvent.VK_DOWN -> {

                    if (direction != 'U') {

                        direction = 'D';

                    }

                }

            }

        }

    }

}
