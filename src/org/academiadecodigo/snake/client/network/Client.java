package org.academiadecodigo.snake.client.network;

import org.academiadecodigo.snake.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class Client {

    private Socket socket;
    private PrintWriter out;

    public void start() {
        start(Constants.DEFAULT_IP_ADDRESS);
    }

    public void start(String ipAddress) {

        socket = ClientHelper.establishConnection(ipAddress, Constants.PORT_NUMBER);

        try {
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new ClientListener(socket)).start();

    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
