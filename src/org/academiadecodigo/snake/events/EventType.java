package org.academiadecodigo.snake.events;

/**
 * Created by codecadet on 14/11/17.
 */
public enum EventType {

    GAME_START,
    OCCUPY_POSITION;

    public static EventType parseEvent(int eventNumber) {
        return values()[eventNumber];
    }
}
