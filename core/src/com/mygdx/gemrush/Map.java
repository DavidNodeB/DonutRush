package com.mygdx.gemrush;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gemrush.objects.Donut;
import com.mygdx.gemrush.objects.Tile;

public class Map {
    private Tile[][] tiles;
    private Donut[][] donuts;
    public static int rows = 8;
    public static int columns = 8;
    public Map() {
        tiles = new Tile[rows][columns]; // assigning 2d array to type Tile
        donuts = new Donut[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                tiles[x][y] = new Tile( x, y, 40);
                donuts[x][y] = new Donut( x, y, 32);
            }
        }
    } // assigns tile position and size

    public void render(SpriteBatch batch) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                Tile tile = tiles[x][y];
                Donut donut = donuts[x][y];
                tile.render(batch); // use render method from tile class
                donut.render(batch);
            }
        }
    }
}