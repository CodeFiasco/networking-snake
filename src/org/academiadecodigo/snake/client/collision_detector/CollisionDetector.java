package org.academiadecodigo.snake.client.collision_detector;

import org.academiadecodigo.snake.game_objects.Snake;
import org.academiadecodigo.snake.game_objects.position.Position;

import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public class CollisionDetector {

    public static boolean freeSpace(List<Snake> snakes, Position position) {

        for (Snake s : snakes) {

            if (s.isAt(position)) {
                return false;
            }
        }

        return !position.isOutOfBounds();
    }
}
