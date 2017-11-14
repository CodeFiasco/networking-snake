package org.academiadecodigo.snake.server;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.events.CreateSnakeEvent;
import org.academiadecodigo.snake.events.GameStartEvent;
import org.academiadecodigo.snake.events.MoveEvent;
import org.academiadecodigo.snake.events.PlayerAssignEvent;
import org.academiadecodigo.snake.game_objects.position.Direction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 14/11/17.
 */
public class Server {

    private ServerSocket serverSocket;

    private int numberOfPlayers;
    private Socket[] clientSockets;

    private int[][] initialSnakePositions = {
            { 1, 1, Direction.RIGHT.ordinal()},
            { 18, 18, Direction.LEFT.ordinal()}
    };

    public static void main(String[] args) {

        int numberOfPlayers = Constants.DEFAULT_NUMBER_OF_PLAYERS;

        if (args.length > 0) {
            try {
                numberOfPlayers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument expected to be a number!");
            }
        }

        new Server().start(numberOfPlayers);
    }

    public void start(int numberOfPlayers) {

        try {
            serverSocket = new ServerSocket(Constants.PORT_NUMBER);

        } catch (IOException e) {
            System.err.println("Could not create Server Socket: " + e.getMessage());
        }

        this.numberOfPlayers = numberOfPlayers;
        clientSockets = new Socket[numberOfPlayers];

        waitClients();
        gameStart();
    }

    private void waitClients() {

        for (int i = 0; i < numberOfPlayers; i++) {

            clientSockets[i] = getClientConnection();
            ServerHelper.sendMessageTo(clientSockets[i], (new PlayerAssignEvent(i)).toString());
            new Thread(new ClientDispatcher(this, clientSockets[i])).start();

        }
    }

    private Socket getClientConnection() {

        try {
            return serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void gameStart() {

        createInitialObjects();
        gameCycle();

    }

    private void createInitialObjects() {
        for (int i = 0; i < numberOfPlayers; i++) {
            ServerHelper.broadcast(clientSockets, (new CreateSnakeEvent(i,
                    initialSnakePositions[i][0],
                    initialSnakePositions[i][1],
                    initialSnakePositions[i][2])).toString());

        }
    }

    private void gameCycle() {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                ServerHelper.broadcast(clientSockets, (new MoveEvent()).toString());

            }
        }, Constants.GAME_TIMER, Constants.GAME_TIMER);
    }

    public void broadcast(String message) {
        ServerHelper.broadcast(clientSockets, message);
    }
}
