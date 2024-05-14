package com.mygdx.donutrush.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;
import com.mygdx.donutrush.screens.MainScreen;

public class Donut extends Actor {
    public Sprite sprite;
    public int donutSize;
    public MainScreen screen;
    public int dragX, dragY;
    public Color color;
    public Boolean dragging;
    public Boolean deleted;

    public Donut(int donutSize) {
        screen = DonutRush.get().mainScreen;
        dragging = false;
        deleted = false;
        this.donutSize = donutSize;
        this.setTouchable(Touchable.enabled);
        color = Color.getRandom();
        switch (color) {
            case BLUE:
                sprite = DonutRush.get().assetHandler.blue;
                break;
            case CHOCOLATE:
                sprite = DonutRush.get().assetHandler.chocolate;
                break;
            case GREEN:
                sprite = DonutRush.get().assetHandler.green;
                break;
            case PINK:
                sprite = DonutRush.get().assetHandler.pink;
                break;
            case RED:
                sprite = DonutRush.get().assetHandler.purple;
                break;
            case WHITE:
                sprite = DonutRush.get().assetHandler.white;
                break;
        }
    }

    public void render(int x, int y) {
        int padding = 4;

        int spacing = 13;

        int totalTileSize = donutSize + spacing;

        int centerX = (Gdx.graphics.getWidth() - Map.rows * totalTileSize) / 2 + x * totalTileSize;

        int centerY = (Gdx.graphics.getHeight() - Map.columns * totalTileSize) / 2 + y * totalTileSize;

        if (dragging) {
            screen.stage.getBatch().draw(sprite, dragX, dragY, donutSize, donutSize);
        } else {
            screen.stage.getBatch().draw(sprite, centerX + padding, centerY + padding, donutSize, donutSize);
        }
    }
}
