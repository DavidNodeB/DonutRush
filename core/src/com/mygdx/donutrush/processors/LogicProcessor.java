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
    public boolean vertical;
    public int shiftR, shiftL, shiftU, shiftD;

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
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (button != Input.Buttons.LEFT || pointer > 0) return false;
        donuts = DonutRush.get().map.donuts;
        dragDonut.dragging = false;
        for (int x = 0; x < Map.rows; x++) {
            for (int y = 0; y < Map.columns; y++) {
                switch (curDirection) {
                    case UP:
                        shiftU = y + 1;
                        break;
                    case DOWN:
                        shiftD = y - 1;
                        break;
                    case LEFT:
                        shiftL = x - 1;
                        break;
                    case RIGHT:
                        shiftR = x + 1;
                        break;
                }
                System.out.println(curDirection);
                if (shiftU < Map.rows) {
                    Donut temp = donuts[x][y];
                    donuts[x][y] = donuts[x][shiftU];
                    donuts[x][shiftU] = temp;
                }
            }
        }
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

