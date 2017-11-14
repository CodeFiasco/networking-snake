package org.academiadecodigo.snake.client.game_objects;

import org.academiadecodigo.snake.client.collision_detector.CollisionDetector;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;
import org.academiadecodigo.snake.client.game_objects.position.Direction;
import org.academiadecodigo.snake.client.game_objects.position.Position;

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

        Position newPosition = new Position(col, row);

        if (!CollisionDetector.isEmpty(snakes, newPosition) || newPosition.isOutOfBounds()) {
            dead = true;
            return;
        }

        positions.add(newPosition);
        grid.addSquare(grid.colToX(col), grid.rowToY(row), gameColor);
    }

    public boolean isAt(Position position) {

        for (Position p : positions) {

            if (p.equals(position)) {
                return true;
            }

        }

        return false;

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isDead() {
        return dead;
    }
}
