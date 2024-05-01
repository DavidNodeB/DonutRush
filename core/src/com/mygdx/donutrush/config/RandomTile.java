package com.mygdx.donutrush.config;

import com.badlogic.gdx.math.MathUtils;

public enum RandomTile {
    NONE,
    BLUE,
    CHOCOLATE,
    GREEN,
    PINK,
    PURPLE,
    WHITE;

    public static RandomTile getRandom() {
        return values()[(MathUtils.random(1, 6))];
    }
}