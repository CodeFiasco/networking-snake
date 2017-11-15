package org.academiadecodigo.snake.events;

/**
 * Created by codecadet on 14/11/17.
 */
public enum EventType {

    GAME_START,
    PLAYER_ASSIGN,
    OCCUPY_SQUARE,
    SNAKE_DIRECTION_CHANGE,
    GAME_OVER;

    public static EventType parseEvent(int eventNumber) {
        return values()[eventNumber];
    }
}
