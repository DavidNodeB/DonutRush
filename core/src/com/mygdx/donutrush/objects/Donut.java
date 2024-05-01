package com.mygdx.donutrush.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;
import com.mygdx.donutrush.config.RandomTile;

public class Donut {
    public Sprite sprite;
    public int donutSize;
    public int dragX, dragY;
    public Boolean dragging;

    public Donut(int donutSize) {
        dragging = false;
        this.donutSize = donutSize;
        assignSprites();
    }
    public void assignSprites() {
        sprite = null;
        switch (RandomTile.getRandom()) {
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
            case PURPLE:
                sprite = DonutRush.get().assetHandler.purple;
                break;
            case WHITE:
                sprite = DonutRush.get().assetHandler.white;
                break;
        }
    }
    public void render(SpriteBatch batch, int x, int y) {
        if (sprite !=null) {

            int padding = 4;

            int spacing = 13;

            int totalTileSize = donutSize + spacing;

            int centerX = (Gdx.graphics.getWidth() - Map.rows * totalTileSize ) / 2 + x * totalTileSize;

            int centerY = (Gdx.graphics.getHeight() - Map.columns * totalTileSize) / 2 + y * totalTileSize;
            if (dragging) {
                batch.draw(sprite, dragX, dragY, donutSize, donutSize);
            } else {
                batch.draw(sprite, centerX + padding, centerY + padding, donutSize, donutSize);
            }
        } else {
            assignSprites();
        }
    }

}
