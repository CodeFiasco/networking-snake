package org.academiadecodigo.snake.client.gui.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
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
}
