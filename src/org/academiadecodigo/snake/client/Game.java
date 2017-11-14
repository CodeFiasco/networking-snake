package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.gui.GameColor;
import org.academiadecodigo.snake.client.gui.Grid;
import org.academiadecodigo.snake.client.gui.GridFactory;
import org.academiadecodigo.snake.client.keyboard.KeyboardListener;
import org.academiadecodigo.snake.client.network.Client;
import org.academiadecodigo.snake.events.SnakeDirectionChangeEvent;
import org.academiadecodigo.snake.game_objects.Snake;
import org.academiadecodigo.snake.game_objects.position.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public final class Game {

    private static Game instance;

    private Grid grid;
    private int playerId;
    private List<Snake> snakes;

    private Client network;
    private KeyboardListener keyboardListener;

    private Game() {
        network = new Client();
        grid = GridFactory.getGrid();
        keyboardListener = new KeyboardListener();
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

    public void addSquare(int col, int row, GameColor color) {
        grid.addSquare(grid.colToX(col), grid.rowToY(row), color);
    }

    public void keyEvent(int key) {
        network.sendMessage((new SnakeDirectionChangeEvent(playerId, Direction.getDirectionByKeyValue(key))).toString());
    }

    public void createSnake(int id, int x, int y, Direction direction) {
        snakes.add(new Snake(grid, x, y, direction, GameColor.values()[id]));
    }

    public void moveObjects() {

        for (Snake s : snakes) {
            s.grow();
        }
    }

    public void changeSnakeDirection(int id, Direction direction) {
        snakes.get(id).setDirection(direction);
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

}
