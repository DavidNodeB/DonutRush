package com.mygdx.donutrush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.donutrush.DonutRush;
import com.mygdx.donutrush.processors.LogicProcessor;

public class MainScreen implements Screen {
    public Stage stage;
    public SpriteBatch batch;
    public MainScreen() {
        batch = DonutRush.get().batch;
        stage = new Stage(new ScreenViewport());
        LogicProcessor logicProcessor = new LogicProcessor();
        Gdx.input.setInputProcessor(logicProcessor);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Texture background = DonutRush.get().assetHandler.background;
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getViewport().apply();
        batch.setProjectionMatrix(stage.getViewport().getCamera().combined);
        batch.begin();
        batch.draw(background, 0, 0, stage.getWidth(), stage.getHeight());
        DonutRush.get().map.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
