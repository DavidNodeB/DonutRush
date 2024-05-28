package com.mygdx.donutrush.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.Map;
import com.mygdx.donutrush.objects.Directions;
import com.mygdx.donutrush.objects.Donut;

public class LogicProcessor implements InputProcessor {
    public Donut dragDonut;
    public Donut hoverDonut;
    private int previousX, previousY;

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
        dragDonut.dragging = false;
        dragDonut = null;
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
        hoverDonut = DonutRush.get().map.getDonut(screenX, Gdx.graphics.getHeight() - screenY);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
            int movementX = screenX - previousX;
            int movementY = screenY - previousY;

            if (movementX > 0) {
                System.out.println("Right");
            } else if (movementX < 0) {
                System.out.println("Left");
            }

            if (movementY > 0) {
                System.out.println("Down");
            } else if (movementY < 0) {
                System.out.println("Up");
            }

            previousX = screenX; // store the screenX then subtract the current screenX by the stored screenX
            previousY = Gdx.graphics.getHeight() - screenY;

            return false;
        }
        @Override
        public boolean scrolled(float amountX, float amountY) {
            return false;
        }
    }

