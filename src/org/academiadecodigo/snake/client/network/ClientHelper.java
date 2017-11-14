package org.academiadecodigo.snake.client.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ClientHelper {

    public static Socket establishConnection(String ipAddress, int portNumber) {

        try {
            return new Socket(ipAddress, portNumber);

        } catch (IOException e) {
            System.err.println("Could not establish connection: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static String listenMessage(Socket socket) {

        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return bf.readLine();

        } catch (IOException e) {
            System.out.println("Socket closed: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
