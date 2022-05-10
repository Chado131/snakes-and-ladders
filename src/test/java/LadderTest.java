import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    public void testConstructor(){
        Movement m = new Ladder(new Cell(5), new Cell(20));
        assertEquals(new Cell(5), m.getTop());
        assertEquals(new Cell(20), m.getBottom());
    }

    @Test
    public void testMove(){
        Player player = new Player("Tester");
        new Ladder(new Cell(40), new Cell(10)).move(player);
        assertEquals(new Cell(40), player.getCell());
    }
}