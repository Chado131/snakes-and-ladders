import java.util.Random;

public class Die {
    Random random;

    public Die() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }

}
