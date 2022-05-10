
package game;
import server.SwingGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    static ArrayList<Player> players = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board(10, 10, 10);
        SwingGUI gui = new SwingGUI(board);

        System.out.println("~~~~~~~~~ SNAKES AND LADDERS ~~~~~~~~~");
        System.out.println("");

        int numPlayers = Integer.parseInt(getInput("How many players for this game?"));
        setUpPlayers(numPlayers);

        while (!gameOver(players)) {

            for (int i = 0; i < numPlayers; i++) {
                System.out.println("");
                Player player = players.get(i);
                Die die = player.getDie();

                takeTurn(player, board, die, gui);
                if (die.getFace() == 6) {
                    takeTurn(player, board, die, gui);
                }
            }
        }

        findWinningPlayer(players);

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

    private static void findWinningPlayer(List<Player> players) {
        for (Player player : players) {
            if (player.hasWon()) {
                System.out.println(player.getName() + " is the winner. Congratulations!");
                break;
            }
        }
    }

    private static void takeTurn(Player player, Board board, Die die, SwingGUI gui) {
        rollDie(player.getName() + ", press ENTER to roll your die.");
        board.takeTurn(player);
        System.out.println(player.getName() + ", you have rolled a " + die.getFace() + ".");
        gui.showOutput(players);
    }

}
