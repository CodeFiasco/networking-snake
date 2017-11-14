package org.academiadecodigo.snake.client.ui.input;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.simplegfx.KeyboardListener;

/**
 * Created by codecadet on 14/11/17.
 */
public class InputListenerFactory {

    private static Input input = Constants.DEFAULT_INPUT;

    public static InputListener getInputListener() {

        switch (input) {

            case SIMPLE_GFX:
                return new KeyboardListener();

            default:
                return new KeyboardListener();
        }
    }

    public static void setInputLibrary(Input library) {
        input = library;
    }
}
