package org.academiadecodigo.snake.client;

import org.academiadecodigo.snake.client.network.Client;

/**
 * Created by codecadet on 14/11/17.
 */
public class Game {

    private static Game instance;

    private Client network;

    private Game() {
        network = new Client();
    }

    public static synchronized Game getInstance() {

        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

    public void init() {
        network.start();
    }

    public void start() {
        System.out.println("start");
    }
}
