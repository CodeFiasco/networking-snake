package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.gui.GameColor;

/**
 * Created by codecadet on 14/11/17.
 */
public class OccupyPositionEvent extends Event {

    private int x;
    private int y;
    private GameColor color;

    public OccupyPositionEvent(int x, int y, GameColor color) {
        super(EventType.OCCUPY_POSITION);
    }

    @Override
    public String toString() {
        return super.toString() + Constants.EVENT_ARGUMENT_SEPARATOR +
                            x   + Constants.EVENT_ARGUMENT_SEPARATOR +
                            y   + Constants.EVENT_ARGUMENT_SEPARATOR +
                            color.ordinal();
    }
}
