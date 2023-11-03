import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeGUITest {
    private TicTacToeGUI ticTacToeGUI;
    private Game game;

    @BeforeEach
    void setUp() {
        SwingUtilities.invokeLater(() -> {
            game = new Game();
            ticTacToeGUI = new TicTacToeGUI(game);
            ticTacToeGUI.setVisible(true);
        });
    }

    @AfterEach
    void tearDown() {
        SwingUtilities.invokeLater(() -> {
            ticTacToeGUI.dispose();
        });
    }

    @Test
    void testWinScenario() {
        SwingUtilities.invokeLater(() -> {
            // Simulate a game where 'X' wins
            ticTacToeGUI.onButtonClick(0, 0);
            ticTacToeGUI.onButtonClick(1, 1);
            ticTacToeGUI.onButtonClick(0, 1);
            ticTacToeGUI.onButtonClick(1, 2);
            ticTacToeGUI.onButtonClick(0, 2);

            // Check the result message displayed on the GUI
            assertEquals("Player X wins!", getDisplayedResultMessage());
        });
    }

    @Test
    void testDrawScenario() {
        SwingUtilities.invokeLater(() -> {
            // Simulate a game that ends in a draw
            ticTacToeGUI.onButtonClick(0, 0);
            ticTacToeGUI.onButtonClick(0, 1);
            ticTacToeGUI.onButtonClick(0, 2);
            ticTacToeGUI.onButtonClick(1, 1);
            ticTacToeGUI.onButtonClick(1, 0);
            ticTacToeGUI.onButtonClick(1, 2);
            ticTacToeGUI.onButtonClick(2, 1);
            ticTacToeGUI.onButtonClick(2, 0);
            ticTacToeGUI.onButtonClick(2, 2);

            // Check the result message displayed on the GUI
            assertEquals("It's a draw!", getDisplayedResultMessage());
        });
    }

    private String getDisplayedResultMessage() {
        return ((JOptionPane) SwingUtilities.getRoot(ticTacToeGUI)).getComponents()[0].toString();
    }
}
