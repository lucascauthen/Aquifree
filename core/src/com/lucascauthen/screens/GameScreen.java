package com.lucascauthen.screens;

import com.badlogic.gdx.Screen;
import com.lucascauthen.screens.transitions.TransitionScreen;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public abstract class GameScreen implements Screen{
    protected AssetLoader loader;
    protected ScreenChangeListener parent;
    public GameScreen(ScreenChangeListener parent) {
        this.parent = parent;
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

    public void addScreenForwards(GameScreen s, GameScreen beforeTransition, GameScreen afterTransition) {
        this.parent.newScreen(s);
        this.parent.newScreen(afterTransition);
        this.parent.newScreen(beforeTransition);
    }
    public void addScreenForwards(GameScreen s) {
        //this.addScreenForwards(s, new FadeTransition(), new FadeTransition());
    }
    public void addScreenBackwards() {
        this.dispose();
        this.parent.popCurScreen();
    }
}
