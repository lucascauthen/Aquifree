package com.lucascauthen.Displays.BaseDisplays;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.Input.InputManager;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.States.StateManager;

import javax.inject.Inject;


/**
 * Created by Administrator on 5/21/2015.
 */
public abstract class TransitionableScreen implements Screen {
    private final AssetManager assetManager;
    private final StateManager stateManager;
    private final LevelManager levelManager;

    public abstract SpriteBatch getSnapShot();

    public TransitionableScreen(AssetManager assetManager, StateManager stateManager, LevelManager levelManager) {
        this.assetManager = assetManager;
        this.stateManager = stateManager;
        this.levelManager = levelManager;
    }

    @Override
    public abstract void show();

    @Override
    public abstract void render(float delta);

    @Override
    public abstract void resize(int width, int height);

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public abstract void dispose();
}
