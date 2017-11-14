package org.academiadecodigo.snake.client.ui.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;

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
    public void addSquare(int col, int row, GameColor color) {

        Rectangle square = new Rectangle(colToX(col), rowToY(row), Constants.SQUARE_SIZE, Constants.SQUARE_SIZE);
        square.setColor(SimpleGfxColorConverter.getColor(color));
        square.fill();
    }

    @Override
    public int colToX(int col) {
        return col * Constants.SQUARE_SIZE + SimpleGfxConstants.PADDING;
    }

    @Override
    public int rowToY(int row) {
        return row * Constants.SQUARE_SIZE + SimpleGfxConstants.PADDING;
    }


}
