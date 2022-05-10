public class Player {
    String name;
    Cell cell;

    public Player (String name) {
        this.name = name;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean hasWon() {
        return false;
    }
}
