package com.lucascauthen.auqifree;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.States.StateManager;
import com.lucascauthen.Modules.Injector;

import javax.inject.Inject;


public class AquifreeGame extends ApplicationAdapter {

    @Inject
    public StateManager stateManager;
    @Inject
    public ScreenManager screenManager;


	@Override
	public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Preferences generalPrefs = Gdx.app.getPreferences("Aquifree Data");
        generalPrefs.putInteger("NumLvLs", 10);
        generalPrefs.flush();
        Injector.getInstance().inject(this);
    }

	@Override
	public void render () {
        stateManager.update(Gdx.graphics.getDeltaTime());
        screenManager.render(Gdx.graphics.getDeltaTime());
	}

    @Override
    public void dispose() {

    }
}
