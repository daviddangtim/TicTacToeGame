import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeGUITest {
    private TicTacToeGUI ticTacToeGUI;
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
        ticTacToeGUI = new TicTacToeGUI(game);
    }

    @AfterEach
    void tearDown() {
        ticTacToeGUI.dispose(); // Close the GUI window
    }

    @Test
    void testButtonClickAndCheckWinner() {
        ticTacToeGUI.setVisible(true);

        // Simulate a game where 'X' wins
        ticTacToeGUI.onButtonClick(0, 0);
        ticTacToeGUI.onButtonClick(1, 1);
        ticTacToeGUI.onButtonClick(0, 1);
        ticTacToeGUI.onButtonClick(1, 2);
        ticTacToeGUI.onButtonClick(0, 2);

        // Ensure the result is displayed, and 'X' is declared the winner
        assertEquals("Player X wins!", ticTacToeGUI.getContentPane().getComponents()[0].toString());
    }

    @Test
    void testButtonClickAndCheckDraw() {
        ticTacToeGUI.setVisible(true);

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

        // Ensure the result is displayed as a draw
        assertEquals("It's a draw!", ticTacToeGUI.getContentPane().getComponents()[0].toString());
    }
}
