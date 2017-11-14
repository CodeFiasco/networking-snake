package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;

/**
 * Created by codecadet on 14/11/17.
 */
public class PlayerAssignEvent extends Event{

    private int playerId;

    public PlayerAssignEvent(int id) {
        super(EventType.PLAYER_ASSIGN);

        playerId = id;
    }

    @Override
    public String toString() {
        return super.toString() + Constants.EVENT_ARGUMENT_SEPARATOR + playerId;
    }
}
