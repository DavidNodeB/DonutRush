package com.mygdx.gemrush.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.gemrush.GemRush;
public class MainScreen implements Screen {
    public Stage stage;
    public SpriteBatch batch;
    public MainScreen() {
        batch = GemRush.get().batch;
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Texture background = GemRush.get().assetHandler.background;
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getViewport().apply();
        batch.setProjectionMatrix(stage.getViewport().getCamera().combined);
        batch.begin();
        batch.draw(background, 0, 0, stage.getWidth(), stage.getHeight());
        GemRush.get().map.render(batch);
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
