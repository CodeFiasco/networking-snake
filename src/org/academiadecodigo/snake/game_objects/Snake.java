package org.academiadecodigo.snake.game_objects;

import org.academiadecodigo.snake.client.gui.GameColor;
import org.academiadecodigo.snake.client.gui.Grid;
import org.academiadecodigo.snake.position.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public class Snake {

    private List<Position> positions;
    private GameColor gameColor;
    private Grid grid;

    public Snake(Grid grid, int col, int row, GameColor gameColor) {
        positions = new LinkedList<>();

        positions.add(new Position(col, row));
        this.gameColor = gameColor;

        this.grid = grid;
        grid.addSquare(col, row, gameColor);
    }

    public void grow(int col, int row) {
        positions.add(new Position(col, row));
        grid.addSquare(col, row, gameColor);
    }
}
