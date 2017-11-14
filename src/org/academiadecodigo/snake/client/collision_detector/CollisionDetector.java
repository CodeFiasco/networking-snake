package org.academiadecodigo.snake.client.collision_detector;

import org.academiadecodigo.snake.game_objects.Snake;

import java.util.List;

/**
 * Created by codecadet on 14/11/17.
 */
public class CollisionDetector {

    public static boolean isEmpty(List<Snake> snakes, int col, int row) {

        for (Snake s : snakes) {

            if (s.isAt(col, row)) {
                return false;
            }
        }

        return true;
    }
}
