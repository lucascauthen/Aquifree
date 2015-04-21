package com.lucascauthen.screens.Transitions;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lucascauthen.screens.*;

/**
 * Created by Administrator on 4/14/2015.
 */
public abstract class Transition extends GameScreen {
    protected Stage before, after;
    protected float duration;
    public boolean isFinished() {
        return isFinished;
    }

    protected boolean isFinished;
    public Transition(Stage before, Stage after, ScreenChanger parent, float duration) {
        super(parent);
        this.before = before;
        this.after = after;
        this.duration = duration;
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
