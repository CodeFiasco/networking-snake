package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.gui.GameColor;
import org.academiadecodigo.snake.client.gui.Grid;
import org.academiadecodigo.snake.client.gui.GridFactory;
import org.academiadecodigo.snake.client.network.Client;

/**
 * Created by codecadet on 14/11/17.
 */
public class Game {

    private static Game instance;

    private Grid grid;

    private Client network;

    private Game() {
        network = new Client();
        grid = GridFactory.getGrid();
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
        System.out.println("start");
    }

    public void addSquare(int x, int y, GameColor color) {
        grid.addSquare(x, y, color);
    }
}
