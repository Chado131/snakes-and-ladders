import game.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CellTest {

    @Test
    public void shouldKnowCell() {
        Cell cell = new Cell(5);
        assertEquals(5, cell.getCellNumber());
    }

    @Test
    public void knowsPosition() {
        assertEquals(new Cell(5), new Cell(5));
        assertNotEquals(new Cell(1), new Cell(5));
    }
}