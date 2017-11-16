package org.academiadecodigo.snake.client.network;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.Utils;
import org.academiadecodigo.snake.client.Game;
import org.academiadecodigo.snake.events.EventType;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by codecadet on 14/11/17.
 */
public class NetworkHelper {

    public static Socket establishConnection(String ipAddress, int portNumber) {

        try {
            return new Socket(ipAddress, portNumber);

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static String listenMessage(BufferedReader bf) {

        try {
            return bf.readLine();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static void interpretMessage(String message) {

        int[] arguments = Utils.parseArguments(message.split(Constants.EVENT_ARGUMENT_SEPARATOR));
        EventType eventType = EventType.parseEvent(arguments[Constants.EVENT_TYPE_SLOT]);

        switch (eventType) {

            case GAME_OVER:
                Game.getInstance().end();
                break;

            case PLAYER_ASSIGN:
                Game.getInstance().setPlayerId(arguments[1]);
                break;

            case OCCUPY_SQUARE:
                Game.getInstance().colorSquare(arguments[1], arguments[2], arguments[3]);
                break;
        }
    }
}
