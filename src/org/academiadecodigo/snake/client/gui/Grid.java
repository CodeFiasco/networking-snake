package org.academiadecodigo.snake.client.gui;

/**
 * Created by codecadet on 14/11/17.
 */
public interface Grid {

    void init(int width, int height);
    void addSquare(int col, int row, GameColor color);
    int xToCol(int x);
    int yToRow(int y);
}
