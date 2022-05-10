import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void createPlayer() {
        Player player = new Player("testy");
    }

    @Test
    public void hasReachedEnd() {
        Player player = new Player("testy");
        Cell cell = new Cell(100);
        player.setCell(cell);
        assertTrue(player.hasWon());
    }

    @Test
    public void hasNotReachedEnd() {
        Player player = new Player("testy");
        Cell cell = new Cell(10);
        player.setCell(cell);
        assertFalse(player.hasWon());
    }

    @Test
    public void canRollDice() {
        Player player = new Player("testy");
        assertTrue(0 < player.rollDice());
    }

    @Test
    @RepeatedTest(10)
    public void playerStartCell() {
        Player player = new Player("testy");
        assertEquals(new Cell(1), player.getCell());
    }

    @Test
    public void canTraverse() {
        Player player = new Player("testy");
        Cell cell = new Cell(10);
        player.setCell(cell);
        assertEquals(new Cell(10), player.getCell());
    }
}