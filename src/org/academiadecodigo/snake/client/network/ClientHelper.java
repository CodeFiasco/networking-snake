package org.academiadecodigo.snake.client.network;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.Utils;
import org.academiadecodigo.snake.client.Game;
import org.academiadecodigo.snake.events.EventType;
import org.academiadecodigo.snake.client.game_objects.position.Direction;

import java.io.BufferedReader;
import java.io.IOException;
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

    public static String listenMessage(BufferedReader bf) {

        try {
            return bf.readLine();

        } catch (Exception e) {
            System.out.println("Socket closed: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static void interpretMessage(String message) {

        int[] arguments = Utils.parseArguments(message.split(Constants.EVENT_ARGUMENT_SEPARATOR));
        EventType eventType = EventType.parseEvent(arguments[Constants.EVENT_TYPE_SLOT]);

        switch (eventType) {

            case GAME_START:
                Game.getInstance().start();
                break;

            case PLAYER_ASSIGN:
                Game.getInstance().setPlayerId(arguments[1]);
                break;

            case CREATE_SNAKE:
                Game.getInstance().createSnake(arguments[1], arguments[2], arguments[3], Direction.values()[arguments[4]]);
                break;

            case MOVE_EVENT:
                Game.getInstance().moveObjects();
                break;

            case SNAKE_DIRECTION_CHANGE:
                Game.getInstance().changeSnakeDirection(arguments[1], Direction.values()[arguments[2]]);
        }
    }
}
