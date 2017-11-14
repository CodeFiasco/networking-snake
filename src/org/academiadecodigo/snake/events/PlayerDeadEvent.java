package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;

public class PlayerDeadEvent extends Event {

    private int playerId;

    public PlayerDeadEvent(int playerId) {
        super(EventType.PLAYER_DEAD);
    }

    @Override
    public String toString() {
        return super.toString() + Constants.EVENT_ARGUMENT_SEPARATOR + playerId;
    }
}
