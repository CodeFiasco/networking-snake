package org.academiadecodigo.snake.game_objects.position;

import org.academiadecodigo.snake.client.Game;

/**
 * Created by codecadet on 14/11/17.
 */
public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public boolean isOutOfBounds() {
        return col < 0 || row < 0 ||
                col >= Game.WIDTH || row >= Game.HEIGHT;
    }

    public boolean equals(Position compare) {
        return compare.getCol() == col && compare.getRow() == row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
