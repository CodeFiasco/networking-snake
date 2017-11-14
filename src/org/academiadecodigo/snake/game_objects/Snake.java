package org.academiadecodigo.snake.game_objects;

import org.academiadecodigo.snake.client.collision_detector.CollisionDetector;
import org.academiadecodigo.snake.client.ui.gui.GameColor;
import org.academiadecodigo.snake.client.ui.gui.Grid;
import org.academiadecodigo.snake.game_objects.position.Direction;
import org.academiadecodigo.snake.game_objects.position.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public class Snake {

    private List<Position> positions;
    private GameColor gameColor;
    private Grid grid;

    private int col;
    private int row;
    private Direction direction;

    private boolean dead;

    public Snake(Grid grid, int col, int row, Direction direction, GameColor gameColor) {
        positions = new LinkedList<>();

        this.col = col;
        this.row = row;

        positions.add(new Position(col, row));
        this.gameColor = gameColor;

        this.grid = grid;
        grid.addSquare(grid.colToX(col), grid.rowToY(row), gameColor);

        this.direction = direction;
    }

    public void grow(List<Snake> snakes) {

        if (dead) {
            return;
        }

        col += direction.getHorizontal();
        row += direction.getVertical();

        if (!CollisionDetector.isEmpty(snakes, col, row)) {
            dead = true;
            return;
        }

        positions.add(new Position(col, row));
        grid.addSquare(grid.colToX(col), grid.rowToY(row), gameColor);
    }

    public boolean isAt(int col, int row) {

        for (Position p : positions) {

            if (p.equals(col, row)) {
                return true;
            }

        }

        return false;

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
