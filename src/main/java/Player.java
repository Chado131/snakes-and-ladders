public class Player {
    String name;
    Cell cellNumber;

    public Player (String name) {
        this.name = name;
    }

    public Cell getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(Cell cellNumber) {
        this.cellNumber = cellNumber;
    }

    public boolean hasWon() {
        return false;
    }
}
