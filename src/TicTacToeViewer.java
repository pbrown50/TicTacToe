import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private Square[][] board;
    private int windowWidth;
    private int windowHeight;
    public TicTacToeViewer(int width, int height, Square[][] board) {
        // Initialize instance variables.
        windowWidth = width;
        windowHeight = height;
        this.board = board;

        // Show the window
        this.setTitle("TIC-TAC-TOE!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(Color.white);
        g.fillRect(0, 0, windowWidth, windowHeight);

        // draw board
        printBoard();
        // draw pieces
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j].draw(g);
            }
        }
    }
}
