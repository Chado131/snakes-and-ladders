package server;

import game.Board;
import game.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    static ArrayList<Player> players = new ArrayList<>();
    static Board board = new Board(10,10,10);

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket( ClientHandler.PORT);

        while (true) {
            try {
                Socket socket = s.accept();
                System.out.println("Connection: " + socket);
                Thread r = new ClientHandler(socket);
                r.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void addPlayer(Player p) {
        players.add(p);
    }

    public static Board getboard() {
        return board;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static void play(Player p){
        board.takeTurn(p);
    }
}
