package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket( ClientHandler.PORT);

        while (true) {
            try {
                Socket socket = s.accept();
                System.out.println("Connection: " + socket);
                Thread r = new ClientHandler(socket);
                r.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
