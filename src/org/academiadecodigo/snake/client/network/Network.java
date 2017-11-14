package org.academiadecodigo.snake.client.network;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.events.Event;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class Network {

    private Socket socket;
    private PrintWriter out;

    public void start() {
        start(Constants.DEFAULT_IP_ADDRESS);
    }

    public void start(String ipAddress) {

        socket = NetworkHelper.establishConnection(ipAddress, Constants.PORT_NUMBER);

        try {
            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(new NetworkListener(socket)).start();

    }

    public void sendMessage(Event event) {
        sendMessage(event.toString());
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void close() {

        try {
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
