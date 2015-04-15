package com.lucascauthen.screens.Transitions;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lucascauthen.screens.GameScreen;
import com.lucascauthen.screens.ScreenChangeListener;

/**
 * Created by Administrator on 4/14/2015.
 */
public abstract class Transition extends GameScreen{
    protected Stage before, after;
    public Transition(Stage before, Stage after, ScreenChangeListener parent) {
        super(parent);
        this.before = before;
        this.after = after;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public abstract void render(float delta);

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

    }
}
