package com.lucascauthen.Managers.Display;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ArrayMap;
import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.BaseDisplays.TransitionDisplay;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Managers.Input.InputManager;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.Sound.SoundManager;
import com.lucascauthen.Managers.States.StateManager;


public class ScreenManager  {

    //Managers are loaded by constuctor
    private final AssetManager assetManager;
    private final LevelManager levelManager;
    private final SoundManager soundManager;

    //Managers that need to be registered
    private StateManager stateManager;
    private boolean isStateManagerRegistered = false;

    private TransitionableScreen activeScreen;
    private TransitionDisplay activeTransition;
    private ArrayMap<ScreenEnum, TransitionableScreen> screens = new ArrayMap<ScreenEnum, TransitionableScreen>();

    boolean isTransitioning = false;

    public ScreenManager(AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
        this.assetManager = assetManager;
        this.levelManager = levelManager;
        this.soundManager = soundManager;
    }
    public void registerStateManager(StateManager newStateManager) {
        this.stateManager = newStateManager;
        isStateManagerRegistered = true;
    }
    public void init() {
        if(isStateManagerRegistered) {
            this.setCurScreen(ScreenEnum.SPLASH);
        }
    }

    private TransitionableScreen setCurScreen(ScreenEnum screenName) {
        this.activeScreen = this.getScreen(screenName);
        this.activeScreen.resume();
        this.activeScreen.show();
        return activeScreen;
    }
    private TransitionableScreen getScreen(ScreenEnum screenName) {
        TransitionableScreen screen = screens.get(screenName);
        if(screen != null) {
            return screen;
        }
        if(isStateManagerRegistered) {
            screens.put(screenName, screenName.getScreen(this.stateManager, this.assetManager, this.levelManager, this.soundManager));
        } else {
            Gdx.app.log("ScreenManager", "Can't create a new screen because the StateManager is not registered with the ScreenManager");
        }
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
    public void changeScreen(ScreenEnum screenName, TransitionEnum transitionName, float length) { //Executes a screen change with a transition in the middle
        this.activeTransition.dispose();
        if(isStateManagerRegistered) {
            this.activeTransition = transitionName.getTransition(this.stateManager, activeScreen.getSnapShot(), getScreen(screenName).getSnapShot(), length);
        } else {
            Gdx.app.log("ScreenManager", "Can't transition because the StateManager is not registered with the ScreenManager");
        }
        this.activeScreen = getScreen(screenName);
        this.activeTransition.start();
    }
    public void changeScreen(ScreenEnum screenName) {
        if(isStateManagerRegistered){
            this.setCurScreen(screenName);
        }
    }

    public void finishedTransition() {
        resume();
    }

    public void setTransionState(boolean newState) { this.isTransitioning = newState; }


    public void render(float delta) {
        if(!isTransitioning)
            activeScreen.render(delta);
        else //When a new transition is created, the isFinished boolean is set to false making the manager render the transition instead of the screen
            activeTransition.render(delta);
    }
}