
package game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static ArrayList<Player> players = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board(10, 10, 10);
        System.out.println("~~~~~~~~~ SNAKES AND LADDERS ~~~~~~~~~");

        int numPlayers = Integer.parseInt(getInput("How many players for this game?"));
        setUpPlayers(numPlayers);

        while (!gameOver(players)) {

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



}
