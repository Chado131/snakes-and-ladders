package server;

import game.Board;
import game.Cell;
import game.Player;
import game.Row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.Color;
import java.util.List;


public class SwingGUI extends JComponent{
    private static final int WIDTH = 500, HEIGHT = 535;
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
//        System.setProperty("myColor", "0XCE8540");
        g.setColor(new Color(133 ,133, 80));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.GRAY);

        boolean isGreen = true;
        int y = 0;

        for (Row row : board.getRows()){
            int x = 0;
            isGreen = !isGreen;
            for (Cell cell : row.getCells()){
                if (isGreen) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.YELLOW);
                }

                isGreen = !isGreen;

                g.fillRect(x, y, 50, 50);
//                        WIDTH/(board.getRows().get(0).getCells().size()-1),
//                        HEIGHT/(board.getRows().size()));

                x+=50;
//                x+=board.getRows().get(0).getCells().size()*5;
            }
            y+=50;
//            y+=HEIGHT/board.getRows().size();
        }

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
