package com.mygdx.donutrush.objects;

import com.badlogic.gdx.math.MathUtils;

public enum Color {
    BLUE,
    CHOCOLATE,
    GREEN,
    PINK,
    PURPLE,
    WHITE;

    public static Color getRandom() {
        return values()[(MathUtils.random(0, 5))];
    }
}
