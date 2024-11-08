import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private Game game;
    private Board board;
    private JFrame frame;
    private JButton[][] boardButtons;
    private JLabel missCounterLabel;
    private JLabel strikeCounterLabel;
    private JLabel totalMissCounterLabel;
    private JLabel totalHitCounterLabel;

    public GUI(Game game, Board board) {
        this.game = game;
        this.board = board;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Battleship Game");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(10, 10));
        boardButtons = new JButton[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boardButtons[i][j] = new JButton();
                int x = i;
                int y = j;
                boardButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.handlePlayerAction(x, y);
                    }
                });
                boardPanel.add(boardButtons[i][j]);
            }
        }

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(4, 1));
        missCounterLabel = new JLabel("Miss Counter: 0");
        strikeCounterLabel = new JLabel("Strike Counter: 0");
        totalMissCounterLabel = new JLabel("Total Miss Counter: 0");
        totalHitCounterLabel = new JLabel("Total Hit Counter: 0");
        statusPanel.add(missCounterLabel);
        statusPanel.add(strikeCounterLabel);
        statusPanel.add(totalMissCounterLabel);
        statusPanel.add(totalHitCounterLabel);

        JPanel buttonPanel = new JPanel();
        JButton playAgainButton = new JButton("Play Again");
        JButton quitButton = new JButton("Quit");
        playAgainButton.addActionListener(e -> game.start());
        quitButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(playAgainButton);
        buttonPanel.add(quitButton);

        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void updateMissCounter(int value) {
        missCounterLabel.setText("Miss Counter: " + value);
    }

    public void updateStrikeCounter(int value) {
        strikeCounterLabel.setText("Strike Counter: " + value);
    }

    public void updateHitCounter(int value) {
        totalHitCounterLabel.setText("Total Hit Counter: " + value);
    }

    public void showWinMessage() {
        JOptionPane.showMessageDialog(frame, "You won! Play again?");
    }

    public void showLoseMessage() {
        JOptionPane.showMessageDialog(frame, "You lost! Play again?");
    }
}
