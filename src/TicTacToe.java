import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    JFrame frame2 = new JFrame();
    JLabel textfield2 = new JLabel();
    JButton yes_button = new JButton("Yes");
    JButton no_button = new JButton("No");
    boolean player1_turn;

    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setTitle("Tic-Tac-Toe");
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25, 25, 25));
        text_field.setForeground(new Color(25, 255, 0));
        text_field.setFont(new Font("Ink Free", Font.BOLD, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_field.setText("O Turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_field.setText("X Turn");
                        check();
                    }
                }
            }
        }

        if (e.getSource() == no_button) {
            System.exit(0);
        }
        if (e.getSource() == yes_button) {
            frame.dispose();
            frame2.dispose();
            new TicTacToe();

        }
    }

    public void firstTurn() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            text_field.setText("X Turn");
        } else {
            player1_turn = false;
            text_field.setText("O Turn");
        }
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
        }

    }

    public void check() {
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("X Wins");
        PlayAgain();

    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("O Wins");
        PlayAgain();

    }

    public void PlayAgain() {

        textfield2.setText("Do you want to play again ? :)");
        textfield2.setBounds(0, 0, 400, 90);
        textfield2.setHorizontalAlignment(JLabel.CENTER);
        textfield2.setFont(new Font("Ink Free", Font.BOLD, 27));
        textfield2.setOpaque(true);
        frame2.add(textfield2, BorderLayout.NORTH);

        yes_button.setBounds(25, 135, 150, 100);
        yes_button.setFocusable(false);
        yes_button.setFont(new Font("Ink Free", Font.BOLD, 27));
        yes_button.addActionListener(this);
        no_button.setBounds(200, 135, 150, 100);
        no_button.setFocusable(false);
        no_button.setFont(new Font("Ink Free", Font.BOLD, 27));
        no_button.addActionListener(this);

        frame2.add(yes_button);
        frame2.add(no_button);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 300);
        frame2.getContentPane().setBackground(new Color(50, 50, 50));
        frame2.setLayout(new BorderLayout());
        frame2.setTitle("Tic-Tac-Toe");

        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
}