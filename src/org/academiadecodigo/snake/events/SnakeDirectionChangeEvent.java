package org.academiadecodigo.snake.events;

import org.academiadecodigo.snake.Constants;
import org.academiadecodigo.snake.client.game_objects.position.Direction;

/**
 * Created by codecadet on 14/11/17.
 */
public class SnakeDirectionChangeEvent extends Event{

    private int id;
    private Direction direction;

    public SnakeDirectionChangeEvent(int id, Direction direction) {
        super(EventType.SNAKE_DIRECTION_CHANGE);

        this.id = id;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return super.toString() + Constants.EVENT_ARGUMENT_SEPARATOR + id + Constants.EVENT_ARGUMENT_SEPARATOR + direction.ordinal();
    }
}
