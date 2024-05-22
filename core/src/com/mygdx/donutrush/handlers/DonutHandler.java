package com.mygdx.donutrush.handlers;

import com.badlogic.gdx.Gdx;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;
import com.mygdx.donutrush.objects.Donut;


public class DonutHandler {
    public int rows, columns;
    public float timer;
    public Donut[][] donuts;
    public DonutHandler() {
        rows = Map.rows;
        columns = Map.columns;
        donuts = DonutRush.get().map.donuts;
        timer = 0;
    }
    public void deleteDonut() {
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows - 2; y++) {
                if (donuts[x][y].color == donuts[x][y + 1].color && donuts[x][y].color == donuts[x][y + 2].color) {
                    donuts[x][y + 2].deleted = true;
                    timer += Gdx.graphics.getDeltaTime();
                    if (timer >= 2) {
                        donuts[x][y].deleted = true;
                    } else if (timer >= 1) {
                        donuts[x][y + 1].deleted = true;
                    }
                    if (timer >= 3) {
                        shiftDonut();
                    }
                }
            }
        }
        for(int y = 0; y < rows; y++) {
            for (int x = 0; x < columns - 2; x++) {
                if (donuts[x][y].color == donuts[x + 1][y].color && donuts[x][y].color == donuts[x + 2][y].color) {
                    donuts[x][y].deleted = true;
                    timer += Gdx.graphics.getDeltaTime();
                    if (timer >= 2) {
                        donuts[x + 2][y].deleted = true;
                    } else if (timer >= 1) {
                        donuts[x + 1][y].deleted = true;
                    }
                    if (timer >= 3) {
                        shiftDonut();
                    }
                }
            }
        }
    }
    public void shiftDonut() {
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows - 1; y++) {
                if (!donuts[x][y].deleted) continue;

                int nextY = y + 1; // get current empty spot and add 1 shifting it down
                while (nextY < rows && donuts[x][nextY].deleted) {
                    nextY++;
                } // create while loop to continue shifting until not empty spots are left

                if (nextY < rows) {
                    Donut temp = donuts[x][y];
                    donuts[x][y] = donuts[x][nextY];
                    donuts[x][nextY] = temp;
                } // get current donut and swap positions with empty space
            }
        }
    }

}
