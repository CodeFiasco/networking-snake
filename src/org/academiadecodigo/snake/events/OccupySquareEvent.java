package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;

/**
 * Created by codecadet on 14/11/17.
 */
public class OccupySquareEvent extends Event {

    private int colorOrdinal;
    private int col;
    private int row;

    public OccupySquareEvent(int colorOrdinal, int col, int row) {
        super(EventType.OCCUPY_SQUARE);

        this.colorOrdinal = colorOrdinal;
        this.col = col;
        this.row = row;
    }

    @Override
    public String toString() {
        return super.toString() + Constants.EVENT_ARGUMENT_SEPARATOR +
                    col         + Constants.EVENT_ARGUMENT_SEPARATOR +
                    row         + Constants.EVENT_ARGUMENT_SEPARATOR +
                    colorOrdinal;
    }
}
