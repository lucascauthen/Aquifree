package com.lucascauthen.auqifree;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.lucascauthen.screens.ScreenManager;
import com.lucascauthen.util.Asset;
import com.lucascauthen.util.AssetLoader;
import com.lucascauthen.modules.AssetLoaderModule;



public class AquifreeGame extends ApplicationAdapter {

    private ScreenManager screenManager;
	private Game game;
    private AssetLoader assetLoader;
	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        this.screenManager = new ScreenManager();
        Preferences generalPrefs = Gdx.app.getPreferences("Aquifree Data");
        generalPrefs.putInteger("NumLvLs", 10);
        generalPrefs.flush();
	}

	@Override
	public void render () {
        screenManager.render(Gdx.graphics.getDeltaTime());
	}

    @Override
    public void dispose() {
        assetLoader.disposeAll();
    }
}
