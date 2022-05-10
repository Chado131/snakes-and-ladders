import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {
    @Test
    public void testConstructor(){
        Movement m = new Movement(new Cell(5), new Cell(20));
        assertEquals(new Cell(5), m.getTop());
        assertEquals(new Cell(20), m.getBottom());
    }
}