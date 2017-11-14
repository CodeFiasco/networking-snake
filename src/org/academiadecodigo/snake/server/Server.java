package org.academiadecodigo.snake.server;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.Game;
import org.academiadecodigo.snake.events.CreateSnakeEvent;
import org.academiadecodigo.snake.events.MoveEvent;
import org.academiadecodigo.snake.events.PlayerAssignEvent;
import org.academiadecodigo.snake.client.game_objects.position.Direction;

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
            { 1,                1,                  Direction.RIGHT.ordinal() },
            { Game.WIDTH - 2,   Game.HEIGHT - 2,    Direction.LEFT.ordinal() },
            { Game.WIDTH - 2,   1,                  Direction.DOWN.ordinal() },
            { 1,                Game.HEIGHT - 2,    Direction.UP.ordinal()}
    };

    public void start(int numberOfPlayers) {

        serverSocket = ServerHelper.createServerSocket();

        if (numberOfPlayers > initialSnakePositions.length) {
            numberOfPlayers = initialSnakePositions.length;
        }

        this.numberOfPlayers = numberOfPlayers;
        clientSockets = new Socket[numberOfPlayers];

        waitClients();
        gameStart();
    }

    private void waitClients() {

        for (int i = 0; i < numberOfPlayers; i++) {

            clientSockets[i] = ServerHelper.getClientConnection(serverSocket);

            ServerHelper.sendMessageTo(clientSockets[i], (new PlayerAssignEvent(i)).toString());

            Thread clientDispatcher = new Thread(new ClientDispatcher(this, clientSockets[i]));
            clientDispatcher.start();

        }
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
