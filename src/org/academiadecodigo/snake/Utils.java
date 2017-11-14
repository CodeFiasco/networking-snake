package org.academiadecodigo.snake;

/**
 * Created by codecadet on 14/11/17.
 */
public class Utils {

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static int[] parseArguments(String[] arguments) throws IllegalArgumentException {

        int[] parsedArguments = new int[arguments.length];

        for (int i = 0; i < arguments.length; i++) {

            if (!isNumber(arguments[i])) {
                throw new IllegalArgumentException();
            }

            parsedArguments[i] = Integer.parseInt(arguments[i]);
        }

        return parsedArguments;
    }
}
