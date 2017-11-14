package org.academiadecodigo.snake.server;

import org.academiadecodigo.snake.Constants;

/**
 * Created by codecadet on 14/11/17.
 */
public class Main {

    public static void main(String[] args) {
        int numberOfPlayers = Constants.DEFAULT_NUMBER_OF_PLAYERS;

        if (args.length > 0) {
            try {
                numberOfPlayers = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument expected to be a number!");
            }
        }

        new Server().start(numberOfPlayers);
    }
}
