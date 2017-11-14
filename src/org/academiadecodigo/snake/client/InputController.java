package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.game_objects.position.Direction;
import org.academiadecodigo.snake.client.network.Network;
import org.academiadecodigo.snake.client.ui.input.Input;
import org.academiadecodigo.snake.client.ui.input.InputHandler;
import org.academiadecodigo.snake.client.ui.input.InputListener;
import org.academiadecodigo.snake.client.ui.input.InputListenerFactory;
import org.academiadecodigo.snake.events.SnakeDirectionChangeEvent;

public class InputController implements InputHandler {

    private InputListener inputListener;
    private Network network;
    private int playerId;

    public InputController(Network network) {
        this.network = network;

        inputListener = InputListenerFactory.getInputListener();
        inputListener.setInputHandler(this);
    }


    @Override
    public void keyPressed(Input input) {
        network.sendMessage(new SnakeDirectionChangeEvent(playerId, Direction.getDirectionByInput(input)));
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
