package org.academiadecodigo.snake.client.network;

import org.academiadecodigo.snake.Constants;

import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class Client {

    private Socket socket;

    public static void main(String[] args) {

        String ipAddress = Constants.DEFAULT_IP_ADDRESS;

        if (args.length > 0) {
            ipAddress = args[0];
        }

        new Client().start(ipAddress);
    }

    public void start() {
        start(Constants.DEFAULT_IP_ADDRESS);
    }

    public void start(String ipAddress) {

        socket = ClientHelper.establishConnection(ipAddress, Constants.PORT_NUMBER);
        new Thread(new ClientListener(socket)).start();

    }
}
