package com.mygdx.donutrush.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;

public class Donut {
    public Sprite sprite;
    public int donutSize;
    public int dragX, dragY;
    public Color color;
    public Boolean dragging;
    public Boolean removed;

    public Donut(int donutSize) {
        dragging = false;
        this.donutSize = donutSize;
        color = Color.getRandom();
        removed = false;
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

    public void render(SpriteBatch batch, int x, int y) {
        int padding = 4;

        int spacing = 13;

        int totalTileSize = donutSize + spacing;

        int centerX = (Gdx.graphics.getWidth() - Map.rows * totalTileSize) / 2 + x * totalTileSize;

        int centerY = (Gdx.graphics.getHeight() - Map.columns * totalTileSize) / 2 + y * totalTileSize;
        if (dragging) {
            batch.draw(sprite, dragX, dragY, donutSize, donutSize);
        } else {
            batch.draw(sprite, centerX + padding, centerY + padding, donutSize, donutSize);
        }

    }
}
