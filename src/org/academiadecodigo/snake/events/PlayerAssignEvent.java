package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;

/**
 * Created by codecadet on 14/11/17.
 */
public class PlayerAssignEvent extends Event{

    private int playerId;
    private int col;
    private int row;

    public PlayerAssignEvent(int id, int col, int row) {
        super(EventType.PLAYER_ASSIGN);

        playerId = id;
        this.col = col;
        this.row = row;
    }

    @Override
    public String toString() {
        return super.toString() + Constants.EVENT_ARGUMENT_SEPARATOR +
                       playerId + Constants.EVENT_ARGUMENT_SEPARATOR +
                       col      + Constants.EVENT_ARGUMENT_SEPARATOR +
                       row      + Constants.EVENT_ARGUMENT_SEPARATOR;
    }
}
