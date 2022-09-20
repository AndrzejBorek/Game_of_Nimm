import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PileTest {

    @org.junit.jupiter.api.Test
    void test_takeStones() {
        //given
        Pile pile = new Pile(2);
        //when
        pile.takeStones(2);
        //then
        assertEquals(0, pile.getStones().size());
    }
}