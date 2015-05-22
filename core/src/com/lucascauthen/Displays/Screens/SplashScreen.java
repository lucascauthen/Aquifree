package com.lucascauthen.Displays.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.lucascauthen.Displays.BaseDisplays.StageDisplay;
import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.BaseDisplays.UiScreen;
import com.lucascauthen.Displays.Screens.MenuItems.MenuText;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Managers.Display.ScreenEnum;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.Sound.SoundManager;
import com.lucascauthen.Managers.States.EventEnum;
import com.lucascauthen.Managers.States.StateManager;


/**
 * Created by Administrator on 4/9/2015.
 */
public class SplashScreen extends TransitionableScreen implements UiScreen {

    private StageDisplay stageDisplay = new StageDisplay();
    private MenuText text;
    private MenuText subText;
    private Table container;

    public SplashScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
        super(stateManager, assetManager, levelManager, soundManager);
        loadUi();
        assignInputListeners();
    }


    @Override
    public SpriteBatch getSnapShot() {
        return null;
    }

    @Override
    public void show() {
        stageDisplay.show();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stageDisplay.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        stageDisplay.resize(width, height);
    }

    @Override
    public void pause() {
        stageDisplay.pause();
    }

    @Override
    public void resume() {
        stageDisplay.resume();
    }

    @Override
    public void hide() {
        stageDisplay.hide();
    }

    @Override
    public void dispose() {
        stageDisplay.dispose();

    }

    @Override
    public void loadUi() {
        this.text = new MenuText(this.assetManager, "Aqifree", Color.BLACK, 70);
        this.subText = new MenuText(this.assetManager, "A  Lucas Cauthen Project", Color.GRAY, 20);
        this.container = new Table();
        container.setFillParent(true);

        container.add(text.getActor()).align(Align.center);
        container.row();
        container.add(subText.getActor()).align(Align.center);
        stageDisplay.stage.addActor(container);
        stageDisplay.stage.addAction(Actions.alpha(1));
    }

    @Override
    public void assignInputListeners() {
        this.stageDisplay.stage.addAction(Actions.sequence(Actions.fadeIn(1.0f), Actions.run(new Runnable() {
            @Override
            public void run() {
                stateManager.addEvent(EventEnum.SCREEN_CHANGE_WITHOUT_TRANSTION, ScreenEnum.PLAY_SCREEN);
            }
        })));
    }

    @Override
    public void disposeUi() {

    }
}
