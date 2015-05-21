package com.lucascauthen.Displays.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lucascauthen.Displays.BaseDisplays.StageDisplay;
import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.BaseDisplays.UiScreen;
import com.lucascauthen.Displays.Screens.MenuItems.MenuText;
import com.lucascauthen.Modules.Injector;

import javax.inject.Inject;


/**
 * Created by Administrator on 4/9/2015.
 */
public class SplashScreen extends TransitionableScreen implements UiScreen {
    @Inject
    public StageDisplay splashDisplay;
    MenuText text;
    Table container;
    public SplashScreen() {
        Injector.getInstance().inject(this);
    }

    @Override
    public SpriteBatch getSnapShot() {
        return null;
    }

    @Override
    public void show() {
        splashDisplay.show();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        splashDisplay.stage.act(delta);
        splashDisplay.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        splashDisplay.resize(width, height);
    }

    @Override
    public void pause() {
        splashDisplay.pause();
    }

    @Override
    public void resume() {
        splashDisplay.resume();
    }

    @Override
    public void hide() {
        splashDisplay.hide();
    }

    @Override
    public void dispose() {
        splashDisplay.dispose();

    }

    @Override
    public void loadUi() {

    }

    @Override
    public void assignInputListeners() {

    }

    @Override
    public void disposeUi() {

    }
}
