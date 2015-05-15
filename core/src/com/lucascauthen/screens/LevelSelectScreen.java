package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Administrator on 4/7/2015.
 */
public class LevelSelectScreen extends GameScreen {
    ArrayList

    public LevelSelectScreen(ScreenChanger setParent) {
        super(setParent);
        this.backScreen = "MainMenu";
        stage.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.changeScreen("MainMenu", ScreenChanger.TransitionType.FADE_IN_OUT, 0.5f);
            }
        });
    }
    public void loadUI() {
        int numLvls = Gdx.app.getPreferences("Aquifree Data").getInteger("NumLvLs");
        
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
