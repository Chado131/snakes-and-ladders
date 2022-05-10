import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    int x;
    int y;
    List<Cell> cells;

    public Row(int x, int y) {
        this.x = x;
        this.y = y;
        this.cells = createCells();

    }

    private List<Cell> createCells() {
        ArrayList<Cell> cells = new ArrayList<>();
        int[] range = IntStream.range(this.x, this.y + 1).toArray();

        for (int i : range) {
            cells.add(new Cell(i));
        }

        return cells;
    }

    public List<Cell> getCells() {
        return this.cells;
    }


}
