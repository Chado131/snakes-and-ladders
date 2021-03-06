package game;

public abstract class Movement {
    private final Cell top;
    private final Cell bottom;

    public Movement(Cell top, Cell bottom){
        this.top = top;
        this.bottom = bottom;
    }

    public Cell getTop() {
        return top;
    }

    public Cell getBottom() {
        return bottom;
    }

    @Override
    public String toString() {
        return "(" + getTop().getCellNumber() + ", " + getBottom().getCellNumber() + ")";
    }

    public abstract void move(Player player);
    

}
