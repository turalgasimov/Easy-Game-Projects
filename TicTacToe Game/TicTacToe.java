import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setBackground(new Color(50, 50, 50));
        label.setForeground(new Color(100, 100, 100));
        label.setFont(new Font("Ink Free", Font.BOLD, 75));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic-Tac-Toe");
        label.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        titlePanel.add(label);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {

                if (player1Turn) {

                    if (Objects.equals(buttons[i].getText(), "")) {

                        buttons[i].setForeground(new Color(200, 200, 200));
                        buttons[i].setText("X");

                        player1Turn = false;

                        label.setText("O Turn");

                        check();

                    }

                } else {

                    buttons[i].setForeground(new Color(255, 255, 255));
                    buttons[i].setText("O");

                    player1Turn = true;

                    label.setText("X Turn");

                    check();

                }

            }

        }

    }

    public void firstTurn() {

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            System.out.println("problem");

        }

        if (random.nextInt(2) == 0) {

            player1Turn = true;
            label.setText("X turn");

        } else {

            player1Turn = false;
            label.setText("O turn");

        }

    }

    public void check() {

        if (

                Objects.equals(buttons[0].getText(), "X") &&
                Objects.equals(buttons[1].getText(), "X") &&
                Objects.equals(buttons[2].getText(), "X")

        ) {

            xWins(0, 1, 2);

        }

        if (

                Objects.equals(buttons[3].getText(), "X") &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[5].getText(), "X")

        ) {

            xWins(3, 4, 5);

        }

        if (

                Objects.equals(buttons[6].getText(), "X") &&
                Objects.equals(buttons[7].getText(), "X") &&
                Objects.equals(buttons[8].getText(), "X")

        ) {

            xWins(6, 7, 8);

        }

        if (
                Objects.equals(buttons[0].getText(), "X") &&
                Objects.equals(buttons[3].getText(), "X") &&
                Objects.equals(buttons[6].getText(), "X")

        ) {

            xWins(0, 3, 6);

        }

        if (

                Objects.equals(buttons[1].getText(), "X") &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[7].getText(), "X")

        ) {

            xWins(1, 4, 7);

        }

        if (

                Objects.equals(buttons[2].getText(), "X") &&
                Objects.equals(buttons[5].getText(), "X") &&
                Objects.equals(buttons[8].getText(), "X")

        ) {

            xWins(2, 5, 8);

        }

        if (

                Objects.equals(buttons[0].getText(), "X") &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[8].getText(), "X")

        ) {

            xWins(0, 4, 8);

        }

        if (

                Objects.equals(buttons[2].getText(), "X") &&
                Objects.equals(buttons[4].getText(), "X") &&
                Objects.equals(buttons[6].getText(), "X")

        ) {

            xWins(2, 4, 6);

        }

        if (

                Objects.equals(buttons[0].getText(), "O") &&
                Objects.equals(buttons[1].getText(), "O") &&
                Objects.equals(buttons[2].getText(), "O")

        ) {

            oWins(0, 1, 2);

        }

        if (

                Objects.equals(buttons[3].getText(), "O") &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[5].getText(), "O")

        ) {

            oWins(3, 4, 5);

        }

        if (

                Objects.equals(buttons[6].getText(), "O") &&
                Objects.equals(buttons[7].getText(), "O") &&
                Objects.equals(buttons[8].getText(), "O")

        ) {

            oWins(6, 7, 8);

        }

        if (
                Objects.equals(buttons[0].getText(), "O") &&
                Objects.equals(buttons[3].getText(), "O") &&
                Objects.equals(buttons[6].getText(), "O")

        ) {

            oWins(0, 3, 6);

        }

        if (

                Objects.equals(buttons[1].getText(), "O") &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[7].getText(), "O")

        ) {

            oWins(1, 4, 7);

        }

        if (

                Objects.equals(buttons[2].getText(), "O") &&
                Objects.equals(buttons[5].getText(), "O") &&
                Objects.equals(buttons[8].getText(), "O")

        ) {

            oWins(2, 5, 8);

        }

        if (

                Objects.equals(buttons[0].getText(), "O") &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[8].getText(), "O")

        ) {

            oWins(0, 4, 8);

        }

        if (

                Objects.equals(buttons[2].getText(), "O") &&
                Objects.equals(buttons[4].getText(), "O") &&
                Objects.equals(buttons[6].getText(), "O")

        ) {

            oWins(2, 4, 6);

        }

    }

    public void xWins(int a, int b, int c) {

        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {

            buttons[i].setEnabled(false);

        }

        label.setText("X wins!!");

    }

    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {

        buttons[i].setEnabled(false);

        }

        label.setText("O wins!!");

    }

}
