# Tic-Tac-Toe Game (Java Swing)
A desktop-based Tic-Tac-Toe game built in Java using the Swing framework. This project follows the MVC (Model-View-Controller) architecture for clean separation of logic, user interface, and event handling.

## Project Overview
The game allows two players to take turns placing their marks (X and O) on a 3×3 board. It detects winning conditions, highlights the winning line, supports restart functionality, and displays status updates dynamically.

This version is built with:
- Java Swing for the GUI
- MVC design pattern for modularity
- Clean object-oriented structure with dedicated models, views, and controllers

## Features
- Two-player gameplay (X and O)
- Graphical UI built with Java Swing
- Restart button to reset the board
- Win detection with automatic highlighting of the winning row
- Draw detection
- MVC architecture for scalable and maintainable code

## Getting Started
### Prerequisites
- Java 17+ (or compatible JDK version)
- IDE or command-line environment for compiling and running Java programs

### Setup
1. Clone this repository:
  ```
  git clone https://github.com/mginham/tic-tac-toe-game-v2.git
  cd tic-tac-toe-game-v2
  ```
2. Compile the project:
  ```
  javac -d bin src/**/*.java
  ```
3. Run the game:
  ```
  java -cp bin App
  ```
Alternatively, open the project in an IDE (e.g., IntelliJ or Eclipse), mark src as the source folder, and run App.java.

## Project Structure
```
tic-tac-toe/
│
├── src/
│   ├── App.java                 # Entry point to launch the game
│   ├── controller/
│   │   └── GameController.java  # Handles game events and logic flow
│   ├── models/
│   │   ├── GameBoard.java       # Game state and rules
│   │   └── Player.java          # Player representation (X or O)
│   └── views/
│       ├── MainWindow.java      # Main window containing game board and restart button
│       └── GameView.java        # UI for the Tic-Tac-Toe grid and status updates
│
└── README.md                    # Project documentation
```

## How to Play
1. Player X goes first.
2. Click any cell to place your mark.
3. Players alternate turns until:
   - One player wins (winning row is highlighted), or
   - The board is full, resulting in a draw.
4. Click Restart to reset the game and play again.

## Notes
- The game logic checks for win conditions across rows, columns, and diagonals.
- MVC pattern allows for future expansions, such as AI players or a score tracker.

## Future Improvements
- Add single-player mode with AI
- Implement score tracking across multiple rounds
- Add animations or sound effects
- Improve UI for better responsiveness
