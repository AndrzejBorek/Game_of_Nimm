import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        Random r = new Random();
        Game game = new Game(players, r.nextInt(5, 20), r.nextInt(5, 20), r.nextInt(5, 20));
        game.play();

    }
}