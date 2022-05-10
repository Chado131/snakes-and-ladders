import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
    @Test
    public void testMove(){
        Player player = new Player("Tester");
        new Snake(new Cell(40), new Cell(10)).move(player);
        assertEquals(new Cell(10), player.getCurrentCell());
    }
}