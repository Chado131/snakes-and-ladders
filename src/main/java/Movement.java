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

    public abstract void move(Player player);

}
