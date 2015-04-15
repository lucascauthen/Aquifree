package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.lucascauthen.screens.Transitions.Transition;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public abstract class GameScreen implements Screen{
    protected ScreenChangeListener parent;
    protected Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public GameScreen(ScreenChangeListener parent) {
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
    public void fadeIn(float time) {
        stage.addAction(Actions.alpha(0));
        stage.addAction(Actions.fadeIn(time));
    }
    public void fadeOut(float time) {
        stage.addAction(Actions.alpha(1));
        stage.addAction(Actions.fadeOut(time));
    }
    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public  abstract void dispose();


    public void toPreviousScreen(ScreenManager.TransitionType transitionType, float length) {
        parent.previousScreen(transitionType, length);
    }
    public void toNewScreen(GameScreen newScreen, ScreenChangeListener.TransitionType transitionType, float length) {
        parent.newScreen(newScreen, transitionType, length);
    }

}
