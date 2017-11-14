package org.academiadecodigo.snake.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class ServerHelper {

    public static void sendMessageTo(Socket clientSocket, String message) {

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            out.write(message + "\n");
            out.flush();

        } catch (IOException e) {
            System.err.println("Client socket closed: " + e.getMessage());
            e.getStackTrace();
        }

    }

    public static void broadcast(Socket[] clientSockets, String message) {

        for (Socket s : clientSockets) {
            sendMessageTo(s, message);
        }

    }
}
