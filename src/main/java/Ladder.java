public class Ladder extends Movement {
    public Ladder(Cell top, Cell bottom) {
        super(top, bottom);
    }

    @Override
    public void move(Player player) {
        player.setCell(getTop());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladder l = (Ladder) o;

        return getBottom() == l.getBottom() && getTop() == l.getTop();
    }
}
