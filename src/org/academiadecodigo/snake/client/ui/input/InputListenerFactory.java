package org.academiadecodigo.snake.client.ui.input;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.ui.simplegfx.KeyboardListener;

/**
 * Created by codecadet on 14/11/17.
 */
public class InputListenerFactory {

    private static InputLibrary inputLibrary = Constants.DEFAULT_INPUT_LIBRARY;

    public static InputListener getInputListener() {

        switch (inputLibrary) {

            case SIMPLE_GFX:
                return new KeyboardListener();

            default:
                return new KeyboardListener();
        }
    }

    public static void setInputLibrary(InputLibrary library) {
        inputLibrary = library;
    }
}
