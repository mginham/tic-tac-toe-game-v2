package models;

// Model to handle the player state
public class Player {
    private String name;
    private int symbolValue;

    // Constructor to initialize the player
    public Player (String name, int symbolValue) {
        this.name = name;
        this.symbolValue = symbolValue;
    }

    // Returns the player name
    public String getName () {
        return name;
    }

    // Returns the player symbol value
    public int getSymbolValue () {
        return symbolValue;
    }

    // Returns the player symbol character (-1 = 'X', 1 = 'O')
    public String getSymbol () {
        return symbolValue == -1 ? "X" : "O";
    }
}
