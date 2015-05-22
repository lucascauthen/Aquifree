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
    public final Stage stage = new Stage();

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isPaused() {
        return isPaused;
    }
    public StageDisplay() {

    }

    @Override
    public void show() {

        isVisible = true;
    }

    @Override
    public void render(float delta) {
        if (!isPaused) {
            stage.act();
        }
        if(isVisible) {
            stage.draw();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        isPaused = true;
    }

    @Override
    public void resume() {
        isPaused = false;
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
