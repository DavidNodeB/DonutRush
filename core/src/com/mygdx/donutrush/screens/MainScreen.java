package com.mygdx.donutrush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
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
        // input handling
        InputMultiplexer multiplexer = new InputMultiplexer();
        LogicProcessor logicProcessor = new LogicProcessor();
        multiplexer.addProcessor(logicProcessor);
        multiplexer.addProcessor(stage);
        multiplexer.setProcessors(stage);
        multiplexer.setProcessors(logicProcessor);
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update(delta);

        Texture background = DonutRush.get().assetHandler.background;

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getViewport().apply();

        batch.setProjectionMatrix(stage.getViewport().getCamera().combined);

        stage.act(delta);

        stage.getBatch().begin();

        stage.getBatch().draw(background, 0, 0, stage.getWidth(), stage.getHeight());

        DonutRush.get().map.render();

        stage.getBatch().end();

        stage.draw();
    }
    public void update(float delta) {
        DonutRush.get().donutHandler.deleteDonut();
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
