package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;
import org.academiadecodigo.snake.client.ui.graphics.GridFactory;
import org.academiadecodigo.snake.client.network.Network;

/**
 * Created by codecadet on 14/11/17.
 */
public final class Game {

    private static Game instance;

    public static final int WIDTH = Constants.GAME_WIDTH / Constants.SQUARE_SIZE;
    public static final int HEIGHT = Constants.GAME_HEIGHT / Constants.SQUARE_SIZE;

    private Grid grid;

    private Network network;
    private InputController inputController;

    private Game() {
        grid = GridFactory.getGrid();

        network = new Network();
        inputController = new InputController(network);
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

    public void setPlayerId(int playerId) {
        inputController.setPlayerId(playerId);
    }

    public void end() {
        network.close();
        System.exit(0);
    }

    public void occupySquare(int col, int row, int gameColorOrdinal) {

        GameColor gameColor = GameColor.values()[gameColorOrdinal];
        grid.addSquare(col, row, gameColor);
    }
}
