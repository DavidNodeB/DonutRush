package com.mygdx.donutrush.handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class AssetHandler {
    public AssetManager manager;
    public Texture background;
    public Texture grid;
    public Texture tileFrame;
    public TextureAtlas atlas;
    public Sprite sprite;
    public Sprite blue;
    public Sprite chocolate;
    public Sprite green;
    public Sprite pink;
    public Sprite purple;
    public Sprite white;
    public AssetHandler() {
        manager = new AssetManager();
        atlas = new TextureAtlas(Gdx.files.internal("donuts/donuts.txt"));
        Textures();
        Sprites();
    }

    public void Textures() {
        // load
        manager.load("backgrounds/background.png", Texture.class);
        manager.load("frames/tileframe.png", Texture.class);
        manager.load("frames/grid.png", Texture.class);
        manager.finishLoading();
        tileFrame = manager.get("frames/tileframe.png", Texture.class);
        background = manager.get("backgrounds/background.png", Texture.class);
        grid = manager.get("frames/grid.png", Texture.class);
        // get
    }
    public void Sprites() {
        blue = atlas.createSprite("donut_blue");
        chocolate = atlas.createSprite("donut_choc");
        green = atlas.createSprite("donut_green");
        pink = atlas.createSprite("donut_pink");
        purple = atlas.createSprite("donut_purple");
        white = atlas.createSprite("donut_white");
    }
    public void dispose () {
        manager.dispose();
    }
}
