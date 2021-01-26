package server;

import server.controller.ServerController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStarter {

    private static final int PORT = 2727;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        Socket clientSocket;
        try {
            serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();

            ServerController serverController = new ServerController();
            serverController.start(clientSocket);
            clientSocket.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
