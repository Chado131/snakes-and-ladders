package server;

import com.google.gson.Gson;
import game.Board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler extends Thread{
    public static final int PORT = 5000;
    private Socket socket;
    String messageFromClient;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void run() {
        try (final BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
             final PrintStream out = new PrintStream(socket.getOutputStream())) {

            while((messageFromClient = in.readLine()) != null) {
                Board board = new Board (10, 10, 10);
                out.println(serialize(board));
            }

        } catch(IOException ex) {
            System.out.println ("Shutting down server : " + ex);
        }
    }

    public static String serialize(Board board){
        Gson gson = new Gson();
        return gson.toJson(board);
    }
}
