package models;

// Model to handle the game state and logic
public class GameBoard {
    private int[][] board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver;

    // Constructor to initialize the board
    public GameBoard (Player player1, Player player2) {
        board = new int[3][3];
        this.player1 = player1;
        this.player2 = player2;
        resetBoard();
    }

    // Resets the gameboard
    public void resetBoard() {
        // Overwrite player marks from every cell to be blank
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = 0;
            }
        }

        // Set a default player to start
        currentPlayer = player1;

        // Reset the game state
        gameOver = false;
    }

    // Let the current player take their turn
    public boolean takeTurn (int row, int col) {
        // Check if the cell is empty and the game is not over
        if (board[row][col] == 0 && !gameOver) {
            // Mark the cell
            board[row][col] = currentPlayer.getSymbolValue();

            // Check if the game has ended
            if (checkWinner() || isBoardFull()) {
                gameOver = true;
            } else {
                // If game is NOT over, switch players
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

            // Valid move
            return true;
        }

        // Invalid move
        return false;
    }

    // Returns the current player
    public Player getCurrentPlayer () {
        return currentPlayer;
    }

    // Returns if the game is over or not
    public boolean isGameOver () {
        return gameOver;
    }

    // Returns the value at a given cell
    public int getCell (int row, int col) {
        return board[row][col];
    }

    // Returns the winner if there is one
    public Player getWinner() {
        return checkWinner() ? currentPlayer : null;
    }

    // Checks if a win condition has been met
    private boolean checkWinner () {
        for (int i = 0; i < 3; i++) {
            // Check for row or column win
            if (checkLine(board[i][0], board[i][1], board[i][2]) || checkLine(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }

        // Check for diagonal win
        if (checkLine(board[0][0], board[1][1], board[2][2]) || checkLine(board[0][2], board[1][1], board[2][0])) {
            return true;
        }

        // No winner yet
        return false;
    }

    // Checks if the given cells share the same value (excluding "blanks")
    private boolean checkLine (int a, int b, int c) {
        return a != 0 && (Math.abs(a + b + c) == 3);
    }

    // Returns if the board is full to call a draw
    private boolean isBoardFull() {
        for (int[] row : board) {
            for (int cell : row) {
                // If a "blank" cell is encountered, the board is NOT full
                if (cell == 0) {
                    return false;
                }
            }
        }

        // The board is full
        return true;
    }
}
