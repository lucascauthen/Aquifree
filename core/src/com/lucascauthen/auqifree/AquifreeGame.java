package com.lucascauthen.auqifree;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.lucascauthen.screens.ScreenManager;
import com.lucascauthen.util.AssetLoader;


public class AquifreeGame extends ApplicationAdapter {

    private ScreenManager screenManager;
	private Game game;
	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        this.screenManager = new ScreenManager();

	}

	@Override
	public void render () {
        screenManager.render(Gdx.graphics.getDeltaTime());
	}

    @Override
    public void dispose() {
        AssetLoader.getInstance().disposeAll();
    }
}
