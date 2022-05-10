import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Row> rows = new ArrayList<>();
    private final ArrayList<Movement> movements = new ArrayList<>();

    public Board(int size_x, int size_y, int number_of_movements){
        for (int y = 0; y < size_y; y++){
            rows.add(new Row(size_x * y + 1, size_x * y + size_x));
        }
        Random random = new Random();
        for (int i = 0; i < number_of_movements; i++){
            int top;
            int bottom;
            do {
                top = random.nextInt(size_x) * (size_x * random.nextInt(size_y) - 1);
                bottom = random.nextInt(size_x) * (size_x * random.nextInt(size_y) - 1);
            } while (top - bottom >= 10
                && getMovementOnCell(new Cell(top)) == null
                && getMovementOnCell(new Cell(bottom)) == null );

            if (random.nextBoolean()){
                movements.add(new Snake(new Cell(top), new Cell(bottom)));
            } else {
                movements.add(new Ladder(new Cell(top), new Cell(bottom)));
            }
        }

    }

    public void addPlayer(String name){
        this.players.add(new Player(name));
    }

    public Movement getMovementOnCell(Cell cell){
        for (Movement movement : movements){
            if (movement.getTop().equals(cell) || movement.getBottom().equals(cell)){
                return movement;
            }
        }
        return null;
    }

}
