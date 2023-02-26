import com.kata.tennis.Game;
import com.kata.tennis.Player;
import com.kata.tennis.ScoreDisplayer;

public class Application {
    public static void main(String[] args) {
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        ScoreDisplayer scoreDisplayer = new ScoreDisplayer();
        Game game = new Game(player1, player2);
        game.addObserver(scoreDisplayer);
        game.startGame(0.5);
    }
}