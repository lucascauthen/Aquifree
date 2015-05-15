package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ArrayMap;
import com.lucascauthen.screens.Transitions.*;
import com.lucascauthen.util.AssetLoader;
import com.lucascauthen.util.MapLoader;


public class ScreenManager implements ScreenChanger {
    private GameScreen activeScreen;
    private ArrayMap<String, GameScreen> screens;
    private AssetLoader assetLoader;
    public Transition curTransition;
    private InputProcessor androidBackProcessor = new InputAdapter() {
        @Override
        public boolean keyDown(int keycode) {
            test();
            if (keycode == Input.Keys.BACK) {
                curScreen().back(0.25f);
            }
            return false;
        }
    };
    public InputMultiplexer inputManager = new InputMultiplexer();
    public ScreenManager() {
        screens = new ArrayMap<String, GameScreen>();
        screens.put("Splash", new SplashScreen(this));
        activeScreen = screens.firstValue();
        inputManager.addProcessor(curScreen().getStage());
        screens.put("MainMenu", new MainMenuScreen(this));
        screens.put("LevelSelect", new LevelSelectScreen(this));
        screens.put("About", new AboutMenuScreen(this));
        screens.put("Settings", new SettingsMenuScreen(this));
        screens.put("Play", new PlayScreen(this));
        this.curTransition = new EmptyTransition(null, null, this, 0);
        Gdx.input.setInputProcessor(this.inputManager);
        Gdx.input.setCatchBackKey(true);
        this.inputManager.addProcessor(androidBackProcessor); //Used to handle back button events
    }
    public void test() {
        Gdx.app.log("ScreenManager", "Back clicked");
    }
    public GameScreen curScreen() {
        return activeScreen;
    }
    public GameScreen setCurScreen(String screenName) {
        GameScreen s;
        inputManager.removeProcessor(curScreen().getStage());
        if((s = screens.get(screenName)) != null) {
            activeScreen = s;
        } else {
            Gdx.app.log("ScreenManager", "Trying to add a screen that doesn't exist.");
        }
        inputManager.addProcessor(curScreen().getStage());
        return activeScreen;
    }
    public GameScreen getScreen(String screenName) {
        GameScreen s;
        if((s = screens.get(screenName)) != null) {
            return s;
        } else {
            Gdx.app.log("ScreenManager", "Trying to add a screen that doesn't exist.");

            return null;
        }
    }
    public void dispose() {

    }
    public void resume() {
        Gdx.input.setInputProcessor(this.inputManager);
    }
    @Override
    public void changeScreen(String screen, TransitionType transitionType, float length) {
        Gdx.input.setInputProcessor(null);
        Stage before = this.curScreen().getStage();
        Stage after = getScreen(screen).getStage();
        this.curTransition = newTransition(transitionType, before, after, length);
        this.setCurScreen(screen);
    }

    @Override
    public void finishedTransition() {
        resume();
    }

    public Transition newTransition(TransitionType type, Stage before, Stage after, float length) {
        Gdx.app.log("ScreenManager", "Creating a new transition object.");
        switch(type) {
            case FADE_IN_OUT:
                return new FadeOutTransition(before, after, this, length);
            case PAN_LEFT:
                //Add later
            case PAN_RIGHT:
                //Add later
            default:
                return new FadeOutTransition(before, after, this, length);
        }
    }
    public void render(float delta) {
        if(this.curTransition.isFinished())
            this.curScreen().render(delta);
        else
            this.curTransition.render(delta);
    }
}
