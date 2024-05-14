package com.mygdx.donutrush.handlers;

import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;
import com.mygdx.donutrush.objects.Donut;


public class DonutHandler {
    public int rows, columns;
    public Donut[][] donuts;
    public DonutHandler() {
        rows = Map.rows;
        columns = Map.columns;
        donuts = DonutRush.get().map.donuts;
    }
    public void deleteDonut() {
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows - 2; y++) {
                if (donuts[x][y].color == donuts[x][y + 1].color && donuts[x][y].color == donuts[x][y + 2].color) {
                    donuts[x][y].deleted = true;
                    donuts[x][y + 1].deleted = true;
                    donuts[x][y + 2].deleted = true;
                    donuts[x][y].remove();
                    donuts[x][y + 1].remove();
                    donuts[x][y + 2].remove();
                }
            }
        }
    }
}
