package client;

import client.controller.ClientController;

import java.io.IOException;
import java.net.Socket;

public class ClientStarter {
    private static final int PORT = 2727;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        ClientController clientController = new ClientController();
        Socket clientSocket = null;
        try {
            clientSocket = new Socket(HOST, PORT);
            clientController.start(clientSocket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
