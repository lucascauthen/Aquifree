package com.lucascauthen.Displays.Transitions;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucascauthen.Managers.States.StateManager;


public abstract class Transition  implements Screen{
    protected final SpriteBatch before;
    protected final SpriteBatch after;
    protected float duration;
    protected StateManager stateManager;
    protected Object[] params;

    private boolean isPaused = false;
    private boolean isVisible = true;




    public Transition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params) {
        this.before = before;
        this.after = after;
        this.duration = length;
        this.stateManager = stateManger;
        this.params = params;
    }

    public abstract void draw();
    public abstract void act();

    @Override
    public void show() {
        isVisible = true;
    }

    @Override
    public void resize(int width, int height) {
        //Don't know if there is anything to put here.
    }

    @Override
    public void render(float delta) {
        while(!isPaused) {
            this.act();
        }
        while(isVisible) {
            this.draw();
        }
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
        before.dispose();
        after.dispose();
    }
}
