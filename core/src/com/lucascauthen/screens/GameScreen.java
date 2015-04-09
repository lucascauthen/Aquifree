package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public abstract class GameScreen implements Screen{
    protected ScreenChangeListener parent;
    protected Stage stage;
    public GameScreen(ScreenChangeListener parent) {
        this.parent = parent;
        //Update please
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
    public void resume() {
        stage.addAction(Actions.alpha(0));
        stage.addAction(Actions.fadeIn(1));
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public abstract void hide();

    @Override
    public  abstract void dispose();

    public void fadeToNewScreen(final GameScreen s, float transtionDuration) {
        stage.addAction(Actions.sequence(Actions.fadeOut(transtionDuration), Actions.run(new Runnable() {
            @Override
            public void run() {
                parent.newScreen(s);
            }
        })));
    }
    public void addScreenForwards(GameScreen s) {
        //this.addScreenForwards(s, new FadeTransition(), new FadeTransition());
    }
    public void fadeToPreviousScreen(float transtionDuration) {
        stage.addAction(Actions.sequence(Actions.fadeOut(transtionDuration), Actions.run(new Runnable() {
            @Override
            public void run() {
                dispose();
                parent.popCurScreen();
            }
        })));
    }
}
