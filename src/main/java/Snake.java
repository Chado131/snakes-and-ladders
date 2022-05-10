public class Snake extends Movement {
    @Override
    public void move(Player player) {
        player.setPosition(getBottom());
    }
}
