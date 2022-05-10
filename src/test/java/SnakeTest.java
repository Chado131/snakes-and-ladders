import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
    @Test
    public void testConstructor(){
        Movement m = new Snake(new Cell(5), new Cell(20));
        assertEquals(new Cell(5), m.getTop());
        assertEquals(new Cell(20), m.getBottom());
    }

    @Test
    public void testMove(){
        Player player = new Player("Tester");
        new Snake(new Cell(40), new Cell(10)).move(player);
        assertEquals(new Cell(10), player.getCell());
    }
}