package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// View to handle the main window appearance
public class MainWindow extends JFrame {
    private GameView gameView;
    private JButton restartBtn;

    // Constructor to initialize the main window
    public MainWindow () {
        setTitle("Tic-Tac-Toe"); // Set the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When closing the window, exit the application
        setLayout(new BorderLayout()); // Add a border layout

        // Create Game view
        gameView = new GameView();

        // Create restart button
        restartBtn = new JButton("Restart");

        // Add elements to the layout
        add(gameView, BorderLayout.CENTER);
        add(restartBtn, BorderLayout.SOUTH);

        // Set the window settings
        setSize(500, 570);
        setLocationRelativeTo(null); // Open in the center of the screen
        setResizable(false);

        // Make the window visible
        setVisible(true);
    }

    // Returns the game view
    public GameView getGameView () {
        return gameView;
    }

    // Adds an action listener to the restart button
    public void setRestartListener (ActionListener listener) {
        restartBtn.addActionListener(listener);
    }
}
