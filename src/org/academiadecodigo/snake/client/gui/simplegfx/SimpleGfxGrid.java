package org.academiadecodigo.snake.client.gui.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.gui.GameColor;
import org.academiadecodigo.snake.client.gui.Grid;

/**
 * Created by codecadet on 14/11/17.
 */
public class SimpleGfxGrid implements Grid {

    private Rectangle grid;

    @Override
    public void init(int width, int height) {

        grid = new Rectangle(SimpleGfxConstants.PADDING, SimpleGfxConstants.PADDING, width, height);
        grid.fill();
    }

    @Override
    public void addSquare(int x, int y, GameColor color) {

        Rectangle square = new Rectangle(SimpleGfxConstants.PADDING + x, SimpleGfxConstants.PADDING + y, Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        square.setColor(SimpleGfxColorConverter.getColor(color));
        square.fill();
    }

    @Override
    public int xToCol(int x) {
        return x * Constants.SQUARE_SIZE + SimpleGfxConstants.PADDING;
    }

    @Override
    public int yToRow(int y) {
        return y * Constants.SQUARE_SIZE + SimpleGfxConstants.PADDING;
    }


}
