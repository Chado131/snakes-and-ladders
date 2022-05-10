public class Snake extends Movement {
    public Snake(Cell top, Cell bottom) {
        super(top, bottom);
    }

    @Override
    public void move(Player player) {
        player.setPosition(getBottom());
    }
}
