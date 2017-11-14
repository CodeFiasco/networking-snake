package org.academiadecodigo.snake.game_objects;

import org.academiadecodigo.snake.game_objects.position.Direction;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;
import org.academiadecodigo.snake.game_objects.position.Position;

import java.util.ArrayList;
import java.util.List;

public class SnakeController {

    private List<Snake> snakes;

    public SnakeController() {
        snakes = new ArrayList<>();
    }

    public void addSnake(int id, int x, int y, Direction direction) {
        snakes.add(new Snake(x, y, direction));
    }

    public Position[] getSnakeHeadPositions() {

        Position[] snakeHeads = new Position[snakes.size()];

        for (int i = 0; i < snakes.size(); i++) {
            snakeHeads[i] = snakes.get(i).getHead();
        }

        return snakeHeads;
    }

    public void moveSnakes() {

        for (Snake s : snakes) {
            s.grow(snakes);
        }
    }

    public void changeSnakeDirection(int id, Direction direction) {
        snakes.get(id).setDirection(direction);
    }

    public int deadSnakes() {

        int deadSnakeNumber = 0;

        for (Snake s : snakes) {
            if (s.isDead()) {
                deadSnakeNumber++;
            }
        }

        return deadSnakeNumber;
    }
}
