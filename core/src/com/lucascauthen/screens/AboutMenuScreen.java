package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by Administrator on 4/7/2015.
 */
public class AboutMenuScreen extends GameScreen {
    @Override
    public void resume() {

    }

    public AboutMenuScreen(ScreenChangeListener parent) {
        super(parent);
        stage = new Stage();
        stage.addAction(Actions.alpha(0));
        stage.addAction(Actions.fadeIn(1));
    }

    @Override
    public void render(float delta) {
        // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
