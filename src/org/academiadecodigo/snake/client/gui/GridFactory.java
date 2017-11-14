package org.academiadecodigo.snake.client.gui;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.gui.simplegfx.SimpleGfxGrid;

/**
 * Created by codecadet on 14/11/17.
 */
public class GridFactory {

    private static Gui gui = Constants.DEFAULT_GUI;

    public static Grid getGrid() {

        switch (gui) {

            case SIMPLE_GFX:
                return new SimpleGfxGrid();

            default:
                return new SimpleGfxGrid();
        }
    }

    public static void setGui(Gui library) {
        gui = library;
    }
}
