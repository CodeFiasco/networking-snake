package org.academiadecodigo.snake.server;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.Game;
import org.academiadecodigo.snake.events.*;
import org.academiadecodigo.snake.game_objects.SnakeController;
import org.academiadecodigo.snake.game_objects.position.Direction;
import org.academiadecodigo.snake.game_objects.position.Position;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by codecadet on 14/11/17.
 */
public final class Server {

    private static Server instance;

    private ServerSocket serverSocket;
    private Socket[] clientSockets;

    private int numberOfPlayers;

    private SnakeController snakeController;

    private Timer moveTimer;

    private int[][] initialSnakePositions = {
            { 1,                1,                  Direction.RIGHT.ordinal() },
            { Game.WIDTH - 2,   Game.HEIGHT - 2,    Direction.LEFT.ordinal() },
            { Game.WIDTH - 2,   1,                  Direction.DOWN.ordinal() },
            { 1,                Game.HEIGHT - 2,    Direction.UP.ordinal()}
    };

    private Server() {
        snakeController = new SnakeController();
    }

    public synchronized static Server getInstance() {

        if (instance == null) {
            instance = new Server();
        }

        return instance;
    }

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

            ServerHelper.sendMessageTo(clientSockets[i], new PlayerAssignEvent(i));

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

            int newSnakeCol = initialSnakePositions[i][0];
            int newSnakeRow = initialSnakePositions[i][1];
            Direction newSnakeDirection = Direction.values()[initialSnakePositions[i][2]];

            ServerHelper.broadcast(clientSockets, new OccupySquareEvent(i, newSnakeCol, newSnakeRow));
            snakeController.addSnake(i, newSnakeCol, newSnakeRow, newSnakeDirection);
        }
    }

    private void gameCycle() {
        moveTimer = new Timer();

        moveTimer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                snakeController.moveSnakes();
                broadcastNewPositions();

                checkGameEnd();

            }
        }, Constants.GAME_TIMER, Constants.GAME_TIMER);
    }

    private void broadcastNewPositions() {

        Position[] newPositions = snakeController.getSnakeHeadPositions();

        for (int i = 0; i < newPositions.length; i++) {
            broadcastEvent(new OccupySquareEvent(i, newPositions[i].getCol(), newPositions[i].getRow()));
        }
    }

    private void checkGameEnd() {

        if (snakeController.deadSnakes() == numberOfPlayers) {
            moveTimer.cancel();
            broadcastEvent(new GameOverEvent());
            ServerHelper.closeConnections(clientSockets);
        }
    }

    public void broadcastEvent(Event event) {
        ServerHelper.broadcast(clientSockets, event);
    }

    public void changeSnakeDirection(int snakeId, int directionOrdinal) {
        snakeController.changeSnakeDirection(snakeId, Direction.values()[directionOrdinal]);
    }
}
