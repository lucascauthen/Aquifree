package com.lucascauthen.auqifree;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.lucascauthen.screens.ScreenManager;


public class AquifreeGame extends Game implements ScreenChanger{

    private ScreenManager screenManager;
	
	@Override
	public void create () {
        this.screenManager = new ScreenManager(this);
        setScreen(screenManager.curScreen());
	}

	@Override
	public void render () {

	}
    public void changeScreen(Screen s) {

    }
}
