package com.lucascauthen.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by Administrator on 4/7/2015.
 */
public abstract class GameScreen implements Screen{
    protected ScreenChanger parent;
    protected Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public GameScreen(ScreenChanger parent) {
        this.parent = parent;
        this.stage = new Stage();
    }
    @Override
    public void show() {

    }
    public abstract void update(float delta);
    @Override
    public abstract void render(float delta);

    @Override
    public void resize(int width, int height) {

    }
    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public  abstract void dispose();



}
