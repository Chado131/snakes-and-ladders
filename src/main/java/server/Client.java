package server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import game.Board;
import game.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String ip = args[0];
        String port = args[1];

        try (Socket socket = new Socket(ip, Integer.parseInt(port));
             PrintStream out = new PrintStream(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream()))
        ) {
            String name = getInput("Please enter your name");
            out.println(name);
            out.flush();
            String serverResponse = in.readLine();

            SwingGUI gui = new SwingGUI(deSerialize(serverResponse));

            String input = "";
            System.out.println("(Push Enter To Roll the Dice)");

            ServerIn t = new ServerIn(in, gui);
            t.start();

            do {
                input = gui.getInput();
                out.println(" ");
                out.flush();
            } while(!input.equals("quit"));

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private static String getInput(String print) {
        String input;
        do {
            System.out.println(print);
            input = scanner.nextLine();
        } while (input.isBlank());
        return input;
    }

    /**
     * this function uses Google Gson a java
     * Takes in a string Json and makes a response object
     * @param json : the string to be converted
     * @return a response object
     */
    public static Board deSerialize(String json){
        Gson gson = new Gson();
        return gson.fromJson(json,Board.class);
    }

    /**
     * this function uses Google Gson a java
     * Takes in a string Json and makes a response object
     * @param json : the string to be converted
     * @return a response object
     */
    public static ArrayList<Player> deSerializePlayers(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<ArrayList<Player>>(){}.getType());
    }

    private static class ServerIn extends Thread{
        BufferedReader in;
        SwingGUI gui;
        public ServerIn(BufferedReader in, SwingGUI gui) {
            this.in = in;
            this.gui = gui;
        }

        @Override
        public void run() {
            try {
                gui.showOutput(deSerializePlayers(in.readLine()));
            } catch (IOException e) {
                            }
        }
    }
}