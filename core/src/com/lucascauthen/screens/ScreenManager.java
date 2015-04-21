package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ArrayMap;
import com.lucascauthen.screens.Transitions.*;
import com.lucascauthen.util.AssetLoader;


public class ScreenManager implements ScreenChanger {
    private GameScreen activeScreen;
    private ArrayMap<java.lang.String, GameScreen> screens;
    private AssetLoader loader;
    public Transition curTransition;
    public ScreenManager() {
        screens = new ArrayMap<java.lang.String, GameScreen>();
        screens.put("Splash", new SplashScreen(this));
        this.activeScreen = screens.firstValue();
        screens.put("MainMenu", new MainMenuScreen(this));
        screens.put("LevelSelect", new LevelSelectScreen(this));
        this.curTransition = new EmptyTransition(null, null, this, 0);
    }
    public GameScreen curScreen() {
        return activeScreen;
    }
    public GameScreen setCurScreen(String screenName) {
        GameScreen s;
        if((s = screens.get(screenName)) != null) {
            activeScreen = s;
        } else {
            Gdx.app.log("ScreenManager", "Trying to add a screen that doesn't exist.");
        }

        return activeScreen;
    }
    public void dispose() {

    }
    public void resume() {
        Gdx.input.setInputProcessor(this.curScreen().getStage());
    }
    @Override
    public void changeScreen(String screen, TransitionType transitionType, float length) {
        Stage before = this.curScreen().getStage();
        Stage after = setCurScreen(screen).getStage();
        this.curTransition = newTransition(transitionType, before, after, length);
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
