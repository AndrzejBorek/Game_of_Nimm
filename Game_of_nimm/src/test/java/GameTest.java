import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void test_setFinished() {
        //given
        Player p1 = new Player("Andrzej");
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        Game game = new Game(players, 1, 2, 3);
        //when
        game.setFinished();
        //then
        assertTrue(game.isFinished());
    }


    @Test
    void test_getSizeOfPiles() {
        //given
        Player p1 = new Player("Player");
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        Game game = new Game(players, 1, 2, 3);
        List<Integer> result = new ArrayList<>();
        //when
        Collections.addAll(result, 1, 2, 3);
        //then
        assertEquals(result, game.getSizeOfPiles());
    }

    @Test
    void test_checkIfPilesAreEmpty() {
        //given
        Player p1 = new Player("Player");
        ArrayList<Player> players = new ArrayList<>();
        players.add(p1);
        Game game = new Game(players, 1, 2, 3);
        //when
        game.getPiles().forEach(p -> p.takeStones(p.getSize()));
        //then
        assertTrue(game.checkIfPilesAreEmpty());
    }


}