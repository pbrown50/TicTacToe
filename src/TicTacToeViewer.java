import javax.swing.*;
import java.awt.*;
import java.awt.Font;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private Square[][] board;
    private TicTacToe t;

    public interface ImageObserver{};
    public TicTacToeViewer(int width, int height, Square[][] board, TicTacToe t) {
        // Initialize instance variables.
        this.board = board;
        this.t = t;
        // Show the window
        this.setTitle("TIC-TAC-TOE!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(Color.white);
        g.fillRect(0, 0, t.WINDOW_WIDTH, t.WINDOW_HEIGHT);

        // draw boxes
        g.setColor(Color.black);
        int x = 100;
        int y = 100;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                g.drawRect(x, y, 200, 200);
                x += 200;
            }
            x = 100;
            y += 200;
        }
        Font f = new Font( "SansSerif", Font.ITALIC, 30 );
        g.setFont(f);
        if (t.isGameOver == true) {
            g.setColor(Color.RED);
        }
        g.drawString("0", 200, 75);
        g.drawString("1", 400, 75);
        g.drawString("2", 600, 75);
        g.drawString("0", 70, 200);
        g.drawString("1", 70, 400);
        g.drawString("2", 70, 600);

        // draw pieces
        int a = 100;
        int b = 100;
        Image marker = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isWinningSquare) {
                    g.setColor(Color.green);
                    g.fillRect(a, b, 200, 200);
                    g.setColor(Color.black);
                    if (board[i][j].getMarker().equals(t.X_MARKER)) {
                        g.drawString("X Wins!", 200, 750);
                    }
                    else if (board[i][j].getMarker().equals(t.O_MARKER)) {
                        g.drawString("O Wins!", 200, 750);
                    }
                    else {
                        g.drawString("It's a tie!", 200, 750);
                    }
                }
                if (board[i][j].getMarker().equals(t.X_MARKER)) {
                    marker = new ImageIcon("Resources/X.png").getImage();
                    g.drawImage(marker, a, b, 200, 200, this);
                }
                else if (board[i][j].getMarker().equals(t.O_MARKER)) {
                    marker = new ImageIcon("Resources/O.png").getImage();
                    g.drawImage(marker, a, b, 200, 200, this);
                }
                a += 200;
                }

            a = 100;
            b += 200;
            }
        }

    }