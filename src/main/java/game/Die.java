package game;

import java.util.Random;

public class Die {
    Random random;
    private int face;

    public Die() {
        this.random = new Random();
        this.face = 0;
    }

    public int roll() {
        int face = random.nextInt(6) + 1;
        this.face = face;
        return face;
    }

    public int getFace() {
        return this.face;
    }

}
