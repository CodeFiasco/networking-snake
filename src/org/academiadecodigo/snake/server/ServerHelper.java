package org.academiadecodigo.snake.server;

import org.academiadecodigo.snake.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ServerHelper {

    public static ServerSocket createServerSocket() {

        try {
            return new ServerSocket(Constants.PORT_NUMBER);

        } catch (IOException e) {
            System.err.println("Could not create Server Socket: " + e.getMessage());
        }

        return null;
    }

    public static Socket getClientConnection(ServerSocket serverSocket) {

        try {
            return serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void sendMessageTo(Socket clientSocket, String message) {

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message);

        } catch (IOException e) {
            System.err.println("Network socket closed: " + e.getMessage());
            e.getStackTrace();
        }

    }

    public static void broadcast(Socket[] clientSockets, String message) {

        for (Socket s : clientSockets) {
            sendMessageTo(s, message);
        }

    }
}
