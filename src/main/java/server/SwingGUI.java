package server;

import game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.management.PlatformLoggingMXBean;
import java.util.*;
import java.awt.Color;
import java.util.List;


public class SwingGUI extends JComponent{
    private static final int WIDTH = 500, HEIGHT = 535;
    private static final int REPAINT_INTERVAL = 50;

    private final JFrame frame;
    private final Board board;
    private final ArrayList<Player> players;

    public SwingGUI(Board board){
        this.board = board;
        this.players = new ArrayList<>();

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
                    g.setColor(new Color(126, 217, 126));
                } else {
                    g.setColor(new Color(255, 249, 137));
                }

                isGreen = !isGreen;

                g.fillRect(x, y, 50, 50);

                x+=50;
            }
            y+=50;
        }

        for (Movement movement: board.getMovements()){
            int top = movement.getTop().getCellNumber();
            int bottom = movement.getBottom().getCellNumber();
            if (movement.getClass() == Snake.class){
                g.setColor(new Color(0 ,100, 0));
            } else {
                g.setColor(new Color(173, 132, 6));
            }
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;

            for (Row row : board.getRows()){
                if (row.getCells().contains(movement.getTop())){
                    x1 = row.getCells().indexOf(movement.getTop());
                    y1 = board.getRows().indexOf(row);
                }
                if (row.getCells().contains(movement.getBottom())){
                    x2 = row.getCells().indexOf(movement.getBottom());
                    y2 = board.getRows().indexOf(row);
                }
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.drawLine(x1*50+25,y1*50+25,x2*50+25,y2*50+25);

            if (movement.getClass() == Snake.class){
                g.fillRect(x1*50+15,y1*50+15, 20,20);
            } else {
                g.fillRect(x2*50+15,y2*50+15, 20,20);
            }
        }

        for (Player player : players) {
            for (Row row : board.getRows()) {
                if (row.getCells().contains(player.getCell())) {
                    int x = row.getCells().indexOf(player.getCell());
                    y = board.getRows().indexOf(row);
                    g.setColor(Color.black);
                    g.drawRect(x * 50 + 10, y * 50 + 10, 30, 30);
                    break;
                }
            }
        }

        y=0;
        for (Row row : board.getRows()){
            int x = 0;
            for (Cell cell : row.getCells()){
                g.setColor(new Color(16, 2, 40));
                g.drawString(String.valueOf(cell.getCellNumber()), x+18, y+29);
                x+=50;
            }
            y+=50;
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
