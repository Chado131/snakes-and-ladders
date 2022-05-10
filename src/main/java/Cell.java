public class Cell {
    private int cellNumber;

    public Cell(int cell) {
        this.cellNumber = cell;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell position = (Cell) o;

        return cellNumber == position.cellNumber;
    }
}
