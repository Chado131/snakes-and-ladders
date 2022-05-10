import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final ArrayList<Row> rows = new ArrayList<>();
    private final ArrayList<Movement> movements = new ArrayList<>();

    public Board(int size_x, int size_y, int number_of_movements){
        boolean reversed = false;
        for (int y = 0; y < size_y; y++){
            if (reversed){
                rows.add(new Row(size_x * y + 1, size_x * y + size_x));
            } else {
                rows.add(new Row(size_x * y + size_x, size_x * y + 1));
            }
            reversed = !reversed;
        }
        Random random = new Random();
        for (int i = 0; i < number_of_movements; i++){
            int top;
            int bottom;
            do {
                top = random.nextInt(size_x) + (size_x * random.nextInt(size_y) - 1);
                bottom = random.nextInt(size_x) + (size_x * random.nextInt(size_y) - 1);
            } while (top - bottom >= 10
                && getMovementOnCell(new Cell(top)) != null
                && getMovementOnCell(new Cell(bottom)) != null );

            if (random.nextBoolean()){
                movements.add(new Snake(new Cell(top), new Cell(bottom)));
            } else {
                movements.add(new Ladder(new Cell(top), new Cell(bottom)));
            }
        }
    }

    public Movement getMovementOnCell(Cell cell){
        System.out.println(cell.getCellNumber());
        for (Movement movement : movements){
            if (movement.getTop().equals(cell) || movement.getBottom().equals(cell)){
                System.out.println(movement);
                return movement;
            }
        }
        return null;
    }

    public void takeTurn(Player player){
        int steps = player.rollDice();
        Cell currentCell = player.getCell();
        Cell newCell = new Cell(currentCell.getCellNumber()+steps);
        Movement movement = getMovementOnCell(newCell);

        player.setCell(newCell);
        if (movement != null){
            movement.move(player);
        }
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }
}
