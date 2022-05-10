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

    public void takeTurn() {

    }

    public boolean hasWon() {
        return this.cell.getCellNumber () == 100;
    }
}
