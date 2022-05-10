import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10,10,10);
        System.out.println(board.getMovements());
        System.out.println(board.getRows());

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

    @RepeatedTest(10)
    void takeTurn() {
        board.getMovements().clear();
        Player player = new Player("tester");
        board.takeTurn(player);
        int cellNumber =  player.getCell().getCellNumber();
        assertTrue(0 < cellNumber && 8 > cellNumber);
    }

    @Test
    void getRows() {
        assertEquals(10, board.getRows().size());
    }

    @Test
    void getMovements() {
        assertEquals(10, board.getMovements().size());
    }
}