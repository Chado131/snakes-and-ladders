import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

    @Test
    public void shouldKnowCell() {
        Cell cell = new Cell(5);
        assertEquals(5, cell.getCellNumber());
    }
}