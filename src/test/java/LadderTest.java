import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    public void testMove(){
        Player player = new Player("Tester");
        new Ladder(new Cell(40), new Cell(10)).move(player);
        assertEquals(new Cell(40), player.getCurrentCell());
    }
}