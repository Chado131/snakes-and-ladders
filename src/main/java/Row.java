import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private int x;
    private int y;
    private final List<Cell> cells = new ArrayList<>();

    public Row(int x, int y) {
        this.x = x;
        this.y = y;
        createCells();
    }

    private void createCells() {
        ArrayList<Cell> cellsList = new ArrayList<>();
        int[] range;
        if(this.x > this.y)
            range = IntStream.range(this.y, this.x + 1).toArray();
        else
            range = IntStream.range(this.x, this.y + 1).toArray();
        for (int i : range) {
            cells.add(new Cell(i));
        }
    }

    public List<Cell> getCells() {
        return this.cells;
    }

    


}
