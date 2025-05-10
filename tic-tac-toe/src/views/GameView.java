package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// View to handle the game appearance
public class GameView extends JPanel {
    private JButton[][] cells = new JButton[3][3];
    private String turn1 = "Player X's turn";
    private JLabel statusLabel = new JLabel(turn1);

    // Constructor to initialize the board
    public GameView () {
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        Font cellFont = new Font(Font.SANS_SERIF, Font.BOLD, 40);

        // Generate every cell to be a blank button
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                cells[r][c] = new JButton(" ");
                cells[r][c].setFont(cellFont);

                // Add the cell to the grid
                gridPanel.add(cells[r][c]);
            }
        }

        // Add the grid and the text label to the layout
        add(statusLabel, BorderLayout.NORTH);
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

    // Disables the buttons for every cell
    public void disableBtns () {
        for (JButton[] row : cells) {
            for (JButton button : row) {
                button.setEnabled(false);
            }
        }
    }

    // Resets the board
    public void resetBtns () {
        // For every cell, set the text to blank and enable the button
        for (JButton[] row : cells) {
            for (JButton button : row) {
                button.setText(" ");
                button.setEnabled(true);
            }
        }

        // Reset the player turn text
        updateStatus(turn1);
    }
}
