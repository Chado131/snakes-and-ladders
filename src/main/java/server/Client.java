package server;

import game.Board;
import game.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws IOException {
        SwingGUI gui = new SwingGUI (new Board (10, 10, 10));
        ArrayList<Player> players = new ArrayList<> ();
        gui.showOutput (players);
//        String ip = args[0];
//        String port = args[1];
//
//        try (Socket socket = new Socket(ip, Integer.parseInt(port));
//             PrintStream out = new PrintStream(socket.getOutputStream());
//             BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream()))
//        ) {
//            SwingGUI gui = new SwingGUI (new Board (10, 10, 10));
//            ArrayList<Player> players = new ArrayList<> ();
//            gui.showOutput (players);
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
    }
}