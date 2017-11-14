package org.academiadecodigo.snake.client.gui.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.snake.client.gui.GameColor;

/**
 * Created by codecadet on 14/11/17.
 */
public class ColorConverter {

    private Color[] colors = {
            Color.GREEN,
            Color.RED,
            Color.YELLOW,
            Color.BLUE
    };

    public Color getColor(GameColor gameColor) {

        if (gameColor.ordinal() >= colors.length) {
            return SimpleGfxConstants.DEFAULT_COLOR;
        }

        return colors[gameColor.ordinal()];

    }
}
