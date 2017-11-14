package org.academiadecodigo.snake.client.game_objects;

import org.academiadecodigo.snake.client.game_objects.position.Direction;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;
import org.academiadecodigo.snake.client.ui.graphics.Grid;

import java.util.ArrayList;
import java.util.List;

public class SnakeController {

    private List<Snake> snakes;
    private Grid grid;

    public SnakeController(Grid grid) {
        snakes = new ArrayList<>();
        this.grid = grid;
    }

    public void addSnake(int id, int x, int y, Direction direction) {
        snakes.add(new Snake(grid, x, y, direction, GameColor.values()[id]));
    }

    public void moveSnakes() {

        for (Snake s : snakes) {
            s.grow(snakes);
        }
    }

    public void changeSnakeDirection(int id, Direction direction) {
        snakes.get(id).setDirection(direction);
    }

    public boolean isDead(int snakeId) {
        return snakes.get(snakeId).isDead();
    }
}
