package com.lucascauthen.Displays.BaseDisplays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Administrator on 5/20/2015.
 */
public class StageDisplay implements Screen {
    private boolean isVisible = true;
    private boolean isPaused = false;
    public Stage stage = new Stage();

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isPaused() {
        return isPaused;
    }

    @Override
    public void show() {

        isVisible = true;
    }

    @Override
    public void render(float delta) {
        while(!isPaused) {
            stage.act();
        }
        while(isVisible) {
            stage.draw();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        isPaused = false;
    }

    @Override
    public void resume() {
        isPaused = true;
    }

    @Override
    public void hide() {
        isVisible = false;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
