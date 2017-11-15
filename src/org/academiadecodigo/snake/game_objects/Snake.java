package org.academiadecodigo.snake.game_objects;

import org.academiadecodigo.snake.client.collision_detector.CollisionDetector;
import org.academiadecodigo.snake.game_objects.position.Direction;
import org.academiadecodigo.snake.game_objects.position.Position;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public class Snake {

    private List<Position> positions;

    private Position currentPosition;
    private Direction direction;

    private boolean dead;

    public Snake(int col, int row, Direction direction) {

        currentPosition = new Position(col, row);

        positions = new LinkedList<>();
        positions.add(currentPosition);

        this.direction = direction;
        dead = false;
    }

    public void grow(List<Snake> snakes) {

        if (dead) {
            return;
        }

        int col = currentPosition.getCol() + direction.getHorizontal();
        int row = currentPosition.getRow() + direction.getVertical();

        Position newPosition = new Position(col, row);

        if (!CollisionDetector.freeSpace(snakes, newPosition)) {
            dead = true;
            return;
        }

        positions.add(newPosition);
        currentPosition = newPosition;
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

    public Position getHead() {
        return currentPosition;
    }
}
