package server;

import game.Board;
import game.Player;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        SwingGUI gui = new SwingGUI(new Board(10,10,10));
        ArrayList<Player> players = new ArrayList<>();
        gui.showOutput(players);
    }
}
