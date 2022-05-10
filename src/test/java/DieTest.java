import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @Test
    void dieRollsBetweenOneAndSix() {
        Die die = new Die();
        assertTrue(die.roll() >= 1 && die.roll() <= 6);
    }

}