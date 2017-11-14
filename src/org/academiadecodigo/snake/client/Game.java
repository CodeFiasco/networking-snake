package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;
import org.academiadecodigo.snake.client.ui.graphics.GridFactory;
import org.academiadecodigo.snake.client.network.Network;
import org.academiadecodigo.snake.client.game_objects.Snake;
import org.academiadecodigo.snake.client.game_objects.position.Direction;

import java.util.ArrayList;
import java.util.List;

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

    private Game() {
        network = new Network();
        inputController = new InputController(network);

        grid = GridFactory.getGrid();
        snakeController = new SnakeController(grid);
    }

    public static synchronized Game getInstance() {

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
    }

    public void changeSnakeDirection(int id, Direction direction) {
        snakeController.changeSnakeDirection(id, direction);
    }

    public void setPlayerId(int playerId) {
        inputController.setPlayerId(playerId);
    }
}
