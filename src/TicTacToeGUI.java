import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {
    private Game game;
    private JButton[][] buttons;

    public TicTacToeGUI(Game game) {
        this.game = game;
        buttons = new JButton[3][3];

        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        initializeButtons();
        addButtonsToFrame();

        setVisible(true);
    }

    private void initializeButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onButtonClick(finalRow, finalCol);
                    }
                });
            }
        }
    }

    private void addButtonsToFrame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                add(buttons[row][col]);
            }
        }
    }


    void onButtonClick(int row, int col) {
        if (game.makeMove(row, col)) {
            buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
            char result = game.checkWin();
            if (result == 'X' || result == 'O') {
                declareWinner(result);
            } else if (result == 'D') {
                declareDraw();
            }
        }
    }

    private void declareWinner(char winner) {
        JOptionPane.showMessageDialog(this, "Player " + winner + " wins!");
        endGame();
    }

    private void declareDraw() {
        JOptionPane.showMessageDialog(this, "It's a draw!");
        endGame();
    }

    private void endGame() {
        game.reset();
        resetButtons();
    }

    private void resetButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        SwingUtilities.invokeLater(() -> {
            new TicTacToeGUI(game);
        });
    }
}
