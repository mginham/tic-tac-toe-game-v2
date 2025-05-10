package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// View to handle the game appearance
public class GameView extends JPanel {
    private JButton[][] cells = new JButton[3][3];
    private String turn1 = "Player X's turn";
    private JPanel statusPanel = new JPanel();
    private JLabel statusLabel = new JLabel(turn1);

    // Constructor to initialize the board
    public GameView () {
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        Font cellFont = new Font(Font.SANS_SERIF, Font.BOLD, 80);

        statusPanel.setLayout(new BorderLayout());
        statusPanel.add(statusLabel, BorderLayout.CENTER);
        statusPanel.setBackground(Color.DARK_GRAY);

        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 50));
        statusLabel.setForeground(Color.white);

        gridPanel.setBackground(Color.LIGHT_GRAY);

        // Generate every cell to be a blank button
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                cells[r][c] = new JButton(" ");
                cells[r][c].setFont(cellFont);
                cells[r][c].setContentAreaFilled(false);
                cells[r][c].setOpaque(true);
                cells[r][c].setBackground(Color.LIGHT_GRAY);
                cells[r][c].setForeground(Color.black);
                cells[r][c].setFocusable(false);

                // Add the cell to the grid
                gridPanel.add(cells[r][c]);
            }
        }

        // Add the grid and the text to the layout
        add(statusPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
    }

    // Adds an action listener to a given cell
    public void setCellListener (int row, int col, ActionListener listener) {
        cells[row][col].addActionListener(listener);
    }

    // Marks a given cell with the current player symbol
    public void updateCell (int row, int col, int value) {
         // Determines the symbols for the player values (-1 for 'X', 1 for 'O', and 0 for ' ')
        String symbol = switch (value) {
            case -1 -> "X";
            case 1 -> "O";
            default -> " ";
        };

        // Mark the cell with the current player symbol
        cells[row][col].setText(symbol);
    }

    // Updates the text label
    public void updateStatus (String msg) {
        statusLabel.setText(msg);
    }

    // Changes the colors of the winning row
    public void highlightWinningRow (int[][] winningRow) {
        for (int[] cell : winningRow) {
            int row = cell[0];
            int col = cell[1];
            cells[row][col].setBackground(Color.GREEN);
        }
    }

    // Resets the board
    public void resetBtns () {
        // For every cell, set the text to blank and enable the button
        for (JButton[] row : cells) {
            for (JButton button : row) {
                button.setText(" ");
                button.setBackground(Color.LIGHT_GRAY);
            }
        }

        // Reset the player turn text
        updateStatus(turn1);
    }
}
