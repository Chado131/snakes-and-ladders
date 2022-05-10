import game.Cell;
import game.Row;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void rowIsSize10() {
        Row row = new Row(1, 10);
        assertEquals(10, row.getCells().size());
    }

    @Test
    void rowCellsAreCorrect() {
        Row row = new Row(1, 10);
        List<Cell> cells = row.getCells();

        assertEquals(1, cells.get(0).getCellNumber());
        assertEquals(10, cells.get(9).getCellNumber());
    }


}