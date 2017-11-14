package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;
import org.academiadecodigo.snake.client.ui.graphics.GridFactory;
import org.academiadecodigo.snake.client.ui.input.InputListener;
import org.academiadecodigo.snake.client.ui.input.InputListenerFactory;
import org.academiadecodigo.snake.client.network.Client;
import org.academiadecodigo.snake.events.SnakeDirectionChangeEvent;
import org.academiadecodigo.snake.client.game_objects.Snake;
import org.academiadecodigo.snake.client.game_objects.position.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public final class Game {

    private static Game instance;
    private int width = Constants.GAME_WIDTH / Constants.SQUARE_SIZE;
    private int height = Constants.GAME_HEIGHT / Constants.SQUARE_SIZE;

    private Grid grid;
    private int playerId;
    private List<Snake> snakes;

    private Client network;
    private InputListener inputListener;

    private Game() {
        network = new Client();
        grid = GridFactory.getGrid();
        inputListener = InputListenerFactory.getInputListener();
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

    public void start() {



    }

    public void keyEvent(int key) {
        network.sendMessage((new SnakeDirectionChangeEvent(playerId, Direction.getDirectionByKeyValue(key))).toString());
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
        this.playerId = playerId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
