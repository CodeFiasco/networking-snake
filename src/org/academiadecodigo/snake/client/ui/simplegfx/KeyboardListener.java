package org.academiadecodigo.snake.client.ui.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.snake.client.Game;
import org.academiadecodigo.snake.client.ui.input.InputListener;

/**
 * Created by codecadet on 14/11/17.
 */
public class KeyboardListener implements KeyboardHandler, InputListener {

    private Keyboard keyboard;

    public KeyboardListener() {

        keyboard = new Keyboard(this);

        KeyboardEvent key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_UP);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_RIGHT);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_DOWN);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_LEFT);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(key);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        Game.getInstance().keyEvent(keyboardEvent.getKey());
    }
}
