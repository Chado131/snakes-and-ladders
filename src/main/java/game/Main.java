
package game;
import server.SwingGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static ArrayList<Player> players = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static SwingGUI gui = new SwingGUI(new Board(10, 10, 10));

    public static void main(String[] args) {
        Board board = new Board(10, 10, 10);
        System.out.println("~~~~~~~~~ SNAKES AND LADDERS ~~~~~~~~~");
        System.out.println("");

        int numPlayers = Integer.parseInt(getInput("How many players for this game?"));
        setUpPlayers(numPlayers);

        while (!gameOver(players)) {

            for (int i = 0; i < numPlayers; i++) {
                System.out.println("");
                rollDie("Player " + (i + 1) + ", press ENTER to roll your die.");
                Player player = players.get(i);
                Die die = player.getDie();
                board.takeTurn(player);
                System.out.println(player.getName() + ", you have rolled a " + die.getFace() + ".");
                System.out.println(player.getName() + ", you are now on cell " + player.getCell().getCellNumber() + ".");

                if (die.getFace() == 6) {
                    rollDie("Player " + (i + 1) + ", press ENTER to roll your die.");
                    board.takeTurn(player);
                    System.out.println(player.getName() + ", you have rolled a " + die.getFace() + ".");
                    System.out.println(player.getName() + ", you are now on cell " + player.getCell().getCellNumber() + ".");
                }
            }

        }

    }

    private static void addPlayer(Player player) {
        players.add(player);
    }

    private static void setUpPlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            String name = getInput("Player name: ");
            addPlayer(new Player(name));
        }
    }

    private static boolean gameOver(List<Player> playerList) {
        for (Player player : playerList) {
            if (player.hasWon()) {
                return true;
            }
        }

        return false;
    }

    private static String getInput(String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine();
        } while (input.isBlank());
        return input;
    }

    private static void rollDie(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
    }



}
