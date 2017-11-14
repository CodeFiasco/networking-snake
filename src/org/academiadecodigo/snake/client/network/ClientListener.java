package org.academiadecodigo.snake.client.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ClientListener implements Runnable {

    private Socket socket;
    private BufferedReader bf;

    public ClientListener(Socket socket) {
        this.socket = socket;

        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (!socket.isClosed()) {

            String message = ClientHelper.listenMessage(bf);

            if (message == null) {
                break;
            }

            ClientHelper.interpretMessage(message);
        }
    }
}
