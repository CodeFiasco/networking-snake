package org.academiadecodigo.snake.events;

/**
 * Created by codecadet on 14/11/17.
 */
public enum EventType {

    GAME_START,
    PLAYER_ASSIGN,
    CREATE_SNAKE,
    MOVE_EVENT,
    SNAKE_DIRECTION_CHANGE;

    public static EventType parseEvent(int eventNumber) {
        return values()[eventNumber];
    }
}
