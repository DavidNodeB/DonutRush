package com.mygdx.gemrush.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gemrush.GemRush;
import com.mygdx.gemrush.Map;

public class Tile {
    public int x;
    public int y;
    public int tileSize;
    public Texture tile;
    public Tile(int x, int y, int tileSize) {
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
    }
    public void render(SpriteBatch batch) {
            int spacing = 5;

            int totalTileSize = tileSize + spacing;

            int centerX = (Gdx.graphics.getWidth() - Map.rows * totalTileSize) / 2 + x * totalTileSize;

            int centerY = (Gdx.graphics.getHeight() - Map.columns * totalTileSize) / 2 + y * totalTileSize;

            tile = GemRush.get().assetHandler.tileFrame;

            batch.draw(tile, centerX, centerY, tileSize, tileSize);
    }
}
