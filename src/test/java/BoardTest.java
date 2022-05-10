import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10,10,10);
    }

    @Test
    void testConstructor(){
        assertEquals(10, board.getRows().size());
        int cellNumber = 1;
        for (Row row : board.getRows()){
            assertEquals(10, row.getCells().size());
            for (Cell cell: row.getCells()){
                assertEquals(cellNumber, cell.getCellNumber());
                cellNumber++;
            }
        }
        assertEquals(100, cellNumber);
    }

    @Test
    void getMovementOnCell() {
        for (Movement movement : board.getMovements()){
            assertEquals(movement, board.getMovementOnCell(movement.getBottom()));
            assertEquals(movement, board.getMovementOnCell(movement.getTop()));
        }
    }

    @Test
    void takeTurn() {
        Player player = new Player("tester");
        board.takeTurn(player);
    }

    @Test
    void getRows() {
    }

    @Test
    void getMovements() {
    }
}