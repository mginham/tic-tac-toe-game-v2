import controller.*;
import models.*;
import views.MainWindow;

public class App {
    public static void main(String[] args) throws Exception {
        //
        javax.swing.SwingUtilities.invokeLater(() -> {
            Player player1 = new Player("Player X", -1);
            Player player2 = new Player("Player O", 1);
            GameBoard model = new GameBoard(player1, player2);
            MainWindow view = new MainWindow();
            new GameController(model, view);
        });
    }
}
