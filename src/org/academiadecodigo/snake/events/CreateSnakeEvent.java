package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;

/**
 * Created by codecadet on 14/11/17.
 */
public class CreateSnakeEvent extends Event {

    private int id;
    private int col;
    private int row;
    private int directionOrdinal;

    public CreateSnakeEvent(int id, int col, int row, int directionOrdinal) {
        super(EventType.CREATE_SNAKE);

        this.id = id;
        this.col = col;
        this.row = row;
        this.directionOrdinal = directionOrdinal;
    }

    @Override
    public String toString() {
        return super.toString()              + Constants.EVENT_ARGUMENT_SEPARATOR +
                            id               + Constants.EVENT_ARGUMENT_SEPARATOR +
                            col              + Constants.EVENT_ARGUMENT_SEPARATOR +
                            row              + Constants.EVENT_ARGUMENT_SEPARATOR +
                            directionOrdinal;
    }
}
