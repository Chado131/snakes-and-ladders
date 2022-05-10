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
}