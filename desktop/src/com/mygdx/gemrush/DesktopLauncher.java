package com.mygdx.gemrush;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.gemrush.GemRush;
import com.mygdx.gemrush.config.GemRushConfig;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(480, 800);
		config.setResizable(false);
		config.setForegroundFPS(60);
		config.setTitle("gemrush");
		new Lwjgl3Application(GemRush.get(), config);
	}
}
