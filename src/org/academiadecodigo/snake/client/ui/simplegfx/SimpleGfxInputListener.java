package org.academiadecodigo.snake.client.ui.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.snake.client.ui.input.Input;
import org.academiadecodigo.snake.client.ui.input.InputHandler;
import org.academiadecodigo.snake.client.ui.input.InputListener;

/**
 * Created by codecadet on 14/11/17.
 */
public class SimpleGfxInputListener implements KeyboardHandler, InputListener {

    private Keyboard keyboard;
    private InputHandler inputHandler;

    public SimpleGfxInputListener() {

        keyboard = new Keyboard(this);

        KeyboardEvent key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_UP);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_RIGHT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_DOWN);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_LEFT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                inputHandler.keyPressed(Input.UP_ARROW);
                break;

            case KeyboardEvent.KEY_RIGHT:
                inputHandler.keyPressed(Input.RIGHT_ARROW);
                break;

            case KeyboardEvent.KEY_DOWN:
                inputHandler.keyPressed(Input.DOWN_ARROW);
                break;

            case KeyboardEvent.KEY_LEFT:
                inputHandler.keyPressed(Input.LEFT_ARROW);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
}
