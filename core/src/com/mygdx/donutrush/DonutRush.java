package com.mygdx.donutrush;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.donutrush.config.DonutRushConfig;
import com.mygdx.donutrush.handlers.AssetHandler;
import com.mygdx.donutrush.handlers.DonutHandler;
import com.mygdx.donutrush.screens.MainScreen;

public class DonutRush extends Game {
	public SpriteBatch batch;
	public AssetHandler assetHandler;
	public DonutHandler donutHandler;
	public Map map;
	private static DonutRush donutrush;

	@Override
	public void create () {
		batch = new SpriteBatch();
		assetHandler = new AssetHandler();
		map = new Map();
		donutHandler = new DonutHandler();
		Gdx.graphics.setWindowedMode(DonutRushConfig.SCREEN_WIDTH, DonutRushConfig.SCREEN_HEIGHT);
		setScreen(new MainScreen());
	}

	@Override
	public void dispose () {
		batch.dispose();
		assetHandler.dispose();
	}

	public static DonutRush get() {
		if (donutrush == null) {
			donutrush = new DonutRush();
		}
		return donutrush;
	} // define a singleton
}
