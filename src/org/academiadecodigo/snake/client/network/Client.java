package org.academiadecodigo.snake.client.network;

import org.academiadecodigo.snake.Constants;

import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class Client {

    private Socket socket;

    public void start() {
        start(Constants.DEFAULT_IP_ADDRESS);
    }

    public void start(String ipAddress) {

        socket = ClientHelper.establishConnection(ipAddress, Constants.PORT_NUMBER);
        new Thread(new ClientListener(socket)).start();

    }
}
