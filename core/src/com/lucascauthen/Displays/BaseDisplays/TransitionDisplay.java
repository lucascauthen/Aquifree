package com.lucascauthen.Displays.BaseDisplays;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Administrator on 5/21/2015.
 */
public abstract class TransitionDisplay implements Screen{
    protected boolean isVisible = true;
    protected boolean isPaused = false;
    protected boolean isFinished = false;

    protected SpriteBatch before;
    protected SpriteBatch after;

    public TransitionDisplay(SpriteBatch before, SpriteBatch after) {
        this.before = before;
        this.after = after;
    }
    public abstract void start();
    public boolean isFinished() {
        return isFinished;
    }
    public abstract void reset();
    public abstract void act();
    public void done() {
        isFinished = true;
    }

    @Override
    public void show() {
        isVisible = true;
    }

    @Override
    public abstract void render(float delta);

    @Override
    public void resize(int width, int height) {
        //Not sure how to impliment this
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
        if(before != null) {
            before.dispose();
        }
        if(after != null) {
            after.dispose();
        }
    }
}
