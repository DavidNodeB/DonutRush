package com.mygdx.donutrush.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;
import com.mygdx.donutrush.objects.Directions;
import com.mygdx.donutrush.objects.Donut;

import java.awt.desktop.SystemSleepEvent;

public class LogicProcessor implements InputProcessor {
    public Donut dragDonut;
    private int previousX, previousY;
    public Directions curDirection;
    public Donut[][] donuts;
    public int originalX, originalY;
    public int hoverX, hoverY;

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) return false;
        dragDonut = DonutRush.get().map.getDonut(screenX, Gdx.graphics.getHeight() - screenY);
        originalX = screenX;
        originalY = Gdx.graphics.getHeight() - screenY;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) return false;
        donuts = DonutRush.get().map.donuts;
        for (int x = 0; x < Map.rows; x++) {
            for (int y = 0; y < Map.columns; y++) {
                if (donuts[x][y].dragging) {
                    switch (curDirection) {
                        case RIGHT :
                            donuts[x][y] = donuts[x + 1][y];
                            donuts[x + 1][y] = donuts[x][y];
                            break;
                        case LEFT:
                            donuts[x][y] = donuts[x - 1][y];
                            donuts[x - 1][y] = donuts[x][y];
                            break;
                        case DOWN:
                            donuts[x][y] = donuts[x][y - 1];
                            donuts[x][y - 1] = donuts[x][y];
                            break;
                        case UP:
                            donuts[x][y] = donuts[x][y + 1];
                            donuts[x][y + 1] = donuts[x][y];
                            break;
                    }
                }
            }
        }
        hoverX = screenX;
        hoverY = Gdx.graphics.getHeight() - screenY;
        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (dragDonut == null) return false;
        dragDonut.dragging = true;
        dragDonut.dragX = screenX - 8;
        dragDonut.dragY = Gdx.graphics.getHeight() - screenY - 16;
        int movementX = screenX - previousX;
        int movementY = Gdx.graphics.getHeight() - screenY - previousY;

        if (movementX > 0) {
            curDirection = Directions.RIGHT;
        } else {
            curDirection = Directions.LEFT;
        }

        if (movementY > 0) {
            curDirection = Directions.UP;
        } else if (movementY < 0) {
            curDirection = Directions.DOWN;
        }
        previousX = screenX;
        previousY = Gdx.graphics.getHeight() - screenY;
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
            return false;
    }
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

