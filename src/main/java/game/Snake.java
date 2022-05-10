package game;

public class Snake extends Movement {
    public Snake(Cell top, Cell bottom) {
        super(top, bottom);
    }

    @Override
    public void move(Player player) {
        player.setCell(getBottom());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snake s = (Snake) o;

        return getBottom() == s.getBottom() && getTop() == s.getTop();
    }
}
