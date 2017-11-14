package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.game_objects.SnakeController;
import org.academiadecodigo.snake.client.ui.graphics.Grid;
import org.academiadecodigo.snake.client.ui.graphics.GridFactory;
import org.academiadecodigo.snake.client.network.Network;
import org.academiadecodigo.snake.client.game_objects.position.Direction;
import org.academiadecodigo.snake.events.PlayerDeadEvent;

/**
 * Created by codecadet on 14/11/17.
 */
public final class Game {

    private static Game instance;

    public static final int WIDTH = Constants.GAME_WIDTH / Constants.SQUARE_SIZE;
    public static final int HEIGHT = Constants.GAME_HEIGHT / Constants.SQUARE_SIZE;

    private Grid grid;
    private SnakeController snakeController;

    private Network network;
    private InputController inputController;

    private int playerId;
    private boolean playerAlive;

    private Game() {
        network = new Network();
        inputController = new InputController(network);

        grid = GridFactory.getGrid();
        snakeController = new SnakeController(grid);

        playerAlive = true;
    }

    public synchronized static Game getInstance() {

        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

    public void init() {
        grid.init(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        network.start();
    }

    public void createSnake(int id, int x, int y, Direction direction) {
        snakeController.addSnake(id, x, y, direction);
    }

    public void moveObjects() {
        snakeController.moveSnakes();

        if(playerAlive && snakeController.isDead(playerId)) {
            playerAlive = false;
            network.sendMessage(new PlayerDeadEvent(playerId));
        }
    }

    public void changeSnakeDirection(int id, Direction direction) {
        snakeController.changeSnakeDirection(id, direction);
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
        inputController.setPlayerId(playerId);
    }

    public void end() {
        network.close();
        System.exit(0);
    }
}
