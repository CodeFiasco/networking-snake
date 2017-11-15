package org.academiadecodigo.snake.server;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.Utils;
import org.academiadecodigo.snake.events.Event;
import org.academiadecodigo.snake.events.EventType;

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

    public static void sendMessageTo(Socket clientSocket, Event event) {
        sendMessageTo(clientSocket, event.toString());
    }

    public static void broadcast(Socket[] clientSockets, String message) {

        for (Socket s : clientSockets) {
            sendMessageTo(s, message);
        }

    }

    public static void broadcast(Socket[] clientSockets, Event event) {
        broadcast(clientSockets, event.toString());
    }

    public static void interpretMessage(String message) {

        int[] arguments = Utils.parseArguments(message.split(Constants.EVENT_ARGUMENT_SEPARATOR));
        EventType eventType = EventType.parseEvent(arguments[Constants.EVENT_TYPE_SLOT]);


        switch (eventType) {

            case SNAKE_DIRECTION_CHANGE:
                Server.getInstance().changeSnakeDirection(arguments[1], arguments[2]);
                break;
        }
    }

    public static void closeConnections(Socket[] clientSockets) {

        for (Socket s : clientSockets) {

            try {
                s.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
