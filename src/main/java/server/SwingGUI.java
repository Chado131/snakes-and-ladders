package server;

import game.Board;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.Color;
import java.util.List;


public class SwingGUI extends JComponent{
    private static final int WIDTH = 500, HEIGHT = 500;
    private static final int REPAINT_INTERVAL = 50;

    private final JFrame frame;
    private final Board board;

    public SwingGUI(Board board){
        this.board = board;

        frame = new JFrame("SNAKES and LADDERS");
        frame.setIconImage(new ImageIcon("assets/images/" + "icon.png").getImage());
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(400, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(this);

        setFocusable(true);
        start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void start() {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                while (true) {
                    try {
                        repaint();
                        try {
                            Thread.sleep(REPAINT_INTERVAL);
                        } catch (InterruptedException ignored) {}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute();
    }

    public void showOutput(ArrayList<Player> players) {

    }
}
