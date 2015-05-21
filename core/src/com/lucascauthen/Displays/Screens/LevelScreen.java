package com.lucascauthen.Displays.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Displays.BaseDisplays.MapDisplay;
import com.lucascauthen.Displays.BaseDisplays.StageDisplay;
import com.lucascauthen.Displays.BaseDisplays.UiScreen;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.States.StateManager;
import com.lucascauthen.Modules.Injector;

/**
 * Created by Administrator on 5/20/2015.
 */
public class LevelScreen extends TransitionableScreen implements UiScreen{


    public final StageDisplay menuDisplay = new StageDisplay();

    public final MapDisplay mapDisplay = new MapDisplay();

    private boolean isLodaed = false;
    private int mapIndex;


    public LevelScreen(AssetManager assetManager, StateManager stateManager, LevelManager levelManager) {
        super(assetManager, stateManager, levelManager);
        Injector.getInstance().inject(this);
    }

    public void loadMap(String mapTitle) {
        this.mapDisplay.loadMap(mapTitle);
    }
    public void toggleMenu() {
        if(menuDisplay.isVisible())
            menuDisplay.hide();
        else
            menuDisplay.show();
    }

    @Override
    public SpriteBatch getSnapShot() {
        return null;
    }
    @Override
    public void show() {
        menuDisplay.hide();
        mapDisplay.show();
    }

    @Override
    public void render(float delta) {
        mapDisplay.render(delta);
        menuDisplay.render(delta); //Important thatthis renders second so it will be displayed on top of the map
    }

    @Override
    public void resize(int width, int height) {
        mapDisplay.resize(width, height); //The menu is a set size
    }

    @Override
    public void pause() { //Pauses game
        menuDisplay.resume();
        mapDisplay.pause();
    }

    @Override
    public void resume() { //Resumes game
        menuDisplay.pause();
        mapDisplay.resume();
    }

    @Override
    public void hide() {
        menuDisplay.hide();
        mapDisplay.hide();
    }

    @Override
    public void dispose() {
        disposeUi();
        menuDisplay.dispose();
        mapDisplay.dispose();
    }

    @Override
    public void loadUi() {
        assert false; //Not done yet
    }

    @Override
    public void assignInputListeners() {
        assert false; //Not done yet
    }

    @Override
    public void disposeUi() {
        //Dispose of all ui items
        assert false; //Not done yet
    }
}
