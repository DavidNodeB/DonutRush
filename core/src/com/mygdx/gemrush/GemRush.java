package com.mygdx.gemrush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gemrush.config.GemRushConfig;
import com.mygdx.gemrush.handlers.AssetHandler;
import com.mygdx.gemrush.screens.MainScreen;

public class GemRush extends Game {
	public SpriteBatch batch;
	public AssetHandler assetHandler;
	public Map map;
	private static GemRush gemrush;

	@Override
	public void create () {
		batch = new SpriteBatch();
		assetHandler = new AssetHandler();
		map = new Map();
		Gdx.graphics.setWindowedMode(GemRushConfig.SCREEN_WIDTH, GemRushConfig.SCREEN_HEIGHT);
		setScreen(new MainScreen());
	}

	@Override
	public void dispose () {
		batch.dispose();
		assetHandler.dispose();
	}

	public static GemRush get() {
		if (gemrush == null) {
			gemrush = new GemRush();
		}
		return gemrush;
	} // define a singleton
}
