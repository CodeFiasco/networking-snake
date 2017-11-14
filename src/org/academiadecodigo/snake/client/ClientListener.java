package org.academiadecodigo.snake.client;

import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ClientListener implements Runnable {

    private Socket socket;

    public ClientListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        String message = "";

        while (!socket.isClosed() && message != null) {

            message = ClientHelper.listenMessage(socket);
        }

    }
}
