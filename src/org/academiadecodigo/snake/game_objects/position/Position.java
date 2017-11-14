package org.academiadecodigo.snake.game_objects.position;

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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
