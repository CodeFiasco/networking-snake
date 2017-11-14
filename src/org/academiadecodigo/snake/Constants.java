package org.academiadecodigo.snake;

import org.academiadecodigo.snake.client.ui.graphics.GraphicLibrary;
import org.academiadecodigo.snake.client.ui.input.InputLibrary;

/**
 * Created by codecadet on 14/11/17.
 */
public class Constants {

    public static final int PORT_NUMBER = 8080;
    public static final int DEFAULT_NUMBER_OF_PLAYERS = 2;

    public static final String DEFAULT_IP_ADDRESS = "localhost";
    public static final String EVENT_ARGUMENT_SEPARATOR = " ";
    public static final int EVENT_TYPE_SLOT = 0;

    public static final GraphicLibrary DEFAULT_GRAPHIC_LIBRARY = GraphicLibrary.SIMPLE_GFX;
    public static final InputLibrary DEFAULT_INPUT_LIBRARY = InputLibrary.SIMPLE_GFX;

    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = 500;
    public static final int SQUARE_SIZE = 10;
    public static final int GAME_TIMER = 500;

}
