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
    private List<Snake> snakes;

    private Network network;
    private InputSwitch inputSwitch;

    private Game() {
        network = new Network();
        inputSwitch = new InputSwitch(network);

        grid = GridFactory.getGrid();
        snakes = new ArrayList<>();
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
        snakes.add(new Snake(grid, x, y, direction, GameColor.values()[id]));
    }

    public void moveObjects() {

        for (Snake s : snakes) {
            s.grow(snakes);
        }
    }

    public void changeSnakeDirection(int id, Direction direction) {
        snakes.get(id).setDirection(direction);
    }

    public void setPlayerId(int playerId) {
        inputSwitch.setPlayerId(playerId);
    }
}
