public class Ladder extends Movement {
    @Override
    public void move(Player player) {
        player.setPosition(getTop());
    }
}
