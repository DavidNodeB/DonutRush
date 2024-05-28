package com.mygdx.donutrush;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.donutrush.objects.Donut;
import com.mygdx.donutrush.screens.MainScreen;

public class Map {
    public Donut[][] donuts;
    public static final int donutSize = 32;
    public static final int tileSize = 40;
    public MainScreen screen;
    public static Texture tileFrame;
    public static final int spacing = 5;
    public static final int rows = 8;
    public static final int columns = 8;
    public static final int totalTileSize = tileSize + spacing;
    public Map() {
        screen = DonutRush.get().mainScreen;
        tileFrame = DonutRush.get().assetHandler.tileFrame;
        donuts = new Donut[rows][columns]; // create a 2d array of donuts]
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                donuts[x][y] = new Donut(donutSize); // assigns x and y also size for donuts
            }
        }
    }

    public void render() {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                    int centerX = (Gdx.graphics.getWidth() - Map.columns * totalTileSize) / 2 + x * totalTileSize;

                    int centerY = (Gdx.graphics.getHeight() - Map.rows * totalTileSize) / 2 + y * totalTileSize;

                    screen.stage.getBatch().draw(tileFrame, centerX, centerY, tileSize, tileSize);
                    Donut donut = donuts[x][y];
                    if (!donut.deleted) {
                        donut.render(x, y);
                    } // if donut is not deleted render
            }
        }
    }
    public Donut getDonut(int x, int y) {
        int realX = Math.clamp((x - (Gdx.graphics.getWidth() - Map.columns * totalTileSize) / 2 ) / totalTileSize, 0, Map.columns);
        int realY = Math.clamp((y - (Gdx.graphics.getHeight() - Map.rows * totalTileSize) / 2 ) / totalTileSize, 0, Map.rows);
        return donuts[realX][realY];
    }
}