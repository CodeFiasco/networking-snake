package org.academiadecodigo.snake.client.game_objects.position;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

/**
 * Created by codecadet on 14/11/17.
 */
public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1, 0);

    private int horizontal;
    private int vertical;

    Direction(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public static Direction getDirectionByKeyValue(int keyValue) {

        switch (keyValue) {

            case KeyboardEvent.KEY_UP:
                return UP;

            case KeyboardEvent.KEY_RIGHT:
                return RIGHT;

            case KeyboardEvent.KEY_DOWN:
                return DOWN;

            case KeyboardEvent.KEY_LEFT:
                return LEFT;
        }

        return null;
    }

    public Direction getOpposite() {

        switch (this) {

            case UP:
                return DOWN;

            case RIGHT:
                return LEFT;

            case DOWN:
                return UP;

            case LEFT:
                return RIGHT;

            default:
                System.err.println("Unexpected direction!");
                return null;
        }
    }


    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }
}
