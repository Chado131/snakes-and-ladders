package server;

import com.google.gson.Gson;
import game.Board;
import game.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    public static final int PORT = 5000;
    private Socket socket;
    String messageFromClient;
    String clientName;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run() {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
             final PrintStream out = new PrintStream(socket.getOutputStream())) {

            clientName = in.readLine();
            Player player = new Player(clientName);
            Server.addPlayer(player);
            out.println(serialize(Server.getboard()));
            System.out.println(serialize(Server.getboard()));

            while((messageFromClient = in.readLine()) != null) {
                in.readLine();
                Server.play(player);
                System.out.println(playerSerialize(Server.getPlayers()));
                out.println(playerSerialize(Server.getPlayers()));
            }

        } catch(IOException ex) {
            System.out.println ("Shutting down server : " + ex);
        }
    }

    public static String playerSerialize(ArrayList<Player> players){
        Gson gson = new Gson();
        return gson.toJson(players);
    }

    public static String serialize(Board board){
        Gson gson = new Gson();
        return gson.toJson(board);
    }
}
