package org.academiadecodigo.snake.client.ui.graphics;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.simplegfx.SimpleGfxGrid;

/**
 * Created by codecadet on 14/11/17.
 */
public class GridFactory {

    private static GraphicLibrary graphicLibrary = Constants.DEFAULT_GRAPHIC_LIBRARY;

    public static Grid getGrid() {

        switch (graphicLibrary) {

            case SIMPLE_GFX:
                return new SimpleGfxGrid();

            default:
                return new SimpleGfxGrid();
        }
    }

    public static void setGraphicLibrary(GraphicLibrary library) {
        graphicLibrary = library;
    }
}
