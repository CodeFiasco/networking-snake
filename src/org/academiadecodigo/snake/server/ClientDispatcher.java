package org.academiadecodigo.snake.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ClientDispatcher implements Runnable {

    private Server server;
    private Socket clientSocket;
    private BufferedReader reader;

    public ClientDispatcher(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;

        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!clientSocket.isClosed()) {

            String message = listenSocket();

            if (message == null) {
                break;
            }

            server.broadcast(message);
        }

    }

    private String listenSocket() {

        try {
            return reader.readLine();

        } catch (IOException e) {
            System.err.println("Socket listen fail: " + e.getMessage());
            e.getStackTrace();
        }

        return null;
    }
}
