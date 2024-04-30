package com.mygdx.gemrush.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gemrush.GemRush;
import com.mygdx.gemrush.Map;
import com.mygdx.gemrush.config.RandomTile;

public class Donut {
    public Sprite sprite;
    public int x;
    public int y;
    public int donutSize;
    public Donut(int x, int y, int donutSize) {
        this.x = x;
        this.y = y;
        this.donutSize = donutSize;
        assignSprites();
    }
    public void assignSprites() {
        sprite = null;
        switch (RandomTile.getRandom()) {
            case BLUE:
                sprite = GemRush.get().assetHandler.blue;
                break;
            case CHOCOLATE:
                sprite = GemRush.get().assetHandler.chocolate;
                break;
            case GREEN:
                sprite = GemRush.get().assetHandler.green;
                break;
            case PINK:
                sprite = GemRush.get().assetHandler.pink;
                break;
            case PURPLE:
                sprite = GemRush.get().assetHandler.purple;
                break;
            case WHITE:
                sprite = GemRush.get().assetHandler.white;
                break;
        }
    }
    public void render(SpriteBatch batch) {
        if (sprite !=null) {

            int padding = 4;

            int spacing = 13;

            int totalTileSize = donutSize + spacing;

            int centerX = (Gdx.graphics.getWidth() - Map.rows * totalTileSize ) / 2 + x * totalTileSize;

            int centerY = (Gdx.graphics.getHeight() - Map.columns * totalTileSize) / 2 + y * totalTileSize;

            batch.draw(sprite, centerX + padding, centerY + padding, donutSize, donutSize);
        } else {
            assignSprites();
        }
    }
}
