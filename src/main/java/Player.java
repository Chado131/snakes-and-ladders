public class Player {
    private String name;
    private Cell cell;
    private final Die die = new Die();

    public Player (String name) {
        this.name = name;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int rollDice() {
        return die.roll();
    }

    public boolean hasWon() {
        return this.cell.getCellNumber() == 100;
    }
}
