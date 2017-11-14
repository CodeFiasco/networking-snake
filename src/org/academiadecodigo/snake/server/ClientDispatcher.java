package org.academiadecodigo.snake.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ClientDispatcher implements Runnable {

    private Socket clientSocket;

    public ClientDispatcher(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        String message = "";

        while (!clientSocket.isClosed() && message != null) {
            message = listenSocket();
        }

    }

    private String listenSocket() {

        try {

            BufferedReader bf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            return bf.readLine();

        } catch (IOException e) {
            System.err.println("Socket listen fail: " + e.getMessage());
            e.getStackTrace();
        }

        return null;
    }
}
