public class Ladder extends Movement {
    public Ladder(Cell top, Cell bottom) {
        super(top, bottom);
    }

    @Override
    public void move(Player player) {
        player.setPosition(getTop());
    }
}
