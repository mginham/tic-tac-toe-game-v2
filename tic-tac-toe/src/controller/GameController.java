package controller;

import models.GameBoard;
import views.MainWindow;

public class GameController {
    private GameBoard model;
    private MainWindow mainWindow;
    private boolean locked;

    // Constructor to initialize the game controller
    public GameController (GameBoard model, MainWindow mainWindow) {
        this.model = model;
        this.mainWindow = mainWindow;

        locked = false;

        initGame();
    }

    // Initializes the game
    private void initGame () {
        var view = mainWindow.getGameView();

        // Set an action listener for every cell
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row;
                final int c = col;
                view.setCellListener(r, c, e -> handleMove(r, c));
            }
        }

        // Set an action listener for the restart button
        mainWindow.setRestartListener(e -> resetGame());
    }

    // Resets the game board
    private void resetGame () {
        locked = false;
        model.resetBoard();
        mainWindow.getGameView().resetBtns();
    }

    // Update necessary fields to reflect a player move
    private void handleMove (int row, int col) {
        // Prevent players from making moves after game is over
        if (locked || model.isGameOver()) {
            return;
        }

        var view = mainWindow.getGameView();

        // Check for valid player turn
        if (model.takeTurn(row, col)) {
            // Mark the given cell with the player symbol
            view.updateCell(row, col, model.getCell(row, col));

            // Check for game over condition
            if (model.isGameOver()) {
                locked = true;

                var winner = model.getWinner();

                if (winner != null) {
                    // Announce the winner
                    view.updateStatus("Player " + winner.getSymbol() + " wins!");
                    view.highlightWinningRow(model.getWinningRow());
                } else {
                    // Accounce a draw
                    view.updateStatus("It's a draw!");
                }

            } else {
                // If game is NOT over, announce next player turn
                view.updateStatus("Plater " + model.getCurrentPlayer().getSymbol() + "'s turn");
            }
        } else {
            // Announce invalid player move
            view.updateStatus("Invalid move. Try again");
        }
    }
}
