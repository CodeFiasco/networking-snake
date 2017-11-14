package org.academiadecodigo.snake.client.ui.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.snake.client.ui.graphics.GameColor;

/**
 * Created by codecadet on 14/11/17.
 */
public class SimpleGfxColorConverter {

    private static Color[] colors = {
            Color.GREEN,
            Color.RED,
            Color.YELLOW,
            Color.BLUE
    };

    public static Color getColor(GameColor gameColor) {

        if (gameColor.ordinal() >= colors.length) {
            return SimpleGfxConstants.DEFAULT_COLOR;
        }

        return colors[gameColor.ordinal()];

    }
}
