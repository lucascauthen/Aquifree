package com.lucascauthen.Managers.Display;

import com.badlogic.gdx.utils.ArrayMap;
import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.BaseDisplays.TransitionDisplay;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Managers.Input.InputManager;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.Sound.SoundManager;
import com.lucascauthen.Managers.States.StateManager;
import com.lucascauthen.Modules.Injector;
import com.lucascauthen.Modules.ManagerModule;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Administrator on 5/20/2015.
 */
public class ScreenManager  {


    private final InputManager inputManager;
    private final AssetManager assetManager;
    private final StateManager stateManager;
    private final LevelManager levelManager;


    private TransitionableScreen activeScreen;
    private TransitionDisplay activeTransition;
    private ArrayMap<ScreenEnum, TransitionableScreen> screens = new ArrayMap<ScreenEnum, TransitionableScreen>();

    public ScreenManager(InputManager inputManager, AssetManager assetManager, StateManager stateManager, LevelManager levelManager) {
        this.inputManager = inputManager;
        this.assetManager = assetManager;
        this.stateManager = stateManager;
        this.levelManager = levelManager;
        this.setCurScreen(ScreenEnum.SPLASH);
    }

    private TransitionableScreen setCurScreen(ScreenEnum screenName) {
        this.activeScreen = this.getScreen(screenName);
        this.activeScreen.resume();
        this.activeScreen.show();
        return activeScreen;
    }
    private TransitionableScreen getScreen(ScreenEnum screenName, Object... params) {
        TransitionableScreen screen = screens.get(screenName);
        if(screen != null) {
            return screen;
        }
        screens.put(screenName, screenName.getScreen(params));
        return screens.get(screenName);
    }
    public void dispose() { //Nothing to dispose
        for(int i = 0; i < screens.size; i++) {
            screens.getValueAt(i).dispose();
        }
    }
    public void resume() {
        activeScreen.resume();
    }
    private void changeScreen(ScreenEnum screenName, TransitionEnum transitionName, float length, Object... params) { //Executes a screen change with a transition in the middle
        this.activeTransition.dispose();
        this.activeTransition = transitionName.getTransition(activeScreen.getSnapShot(), getScreen(screenName).getSnapShot(), length, params);
        this.activeScreen = getScreen(screenName);
        this.activeTransition.start();
    }

    public void finishedTransition() {
        resume();
    }
    public void render(float delta) {
        if(activeTransition.isFinished())
            activeScreen.render(delta);
        else //When a new transition is created, the isFinished boolean is set to false making the manager render the transition instead of the screen
            activeScreen.render(delta);
    }
}