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

/*
    Purpose: Serves as the brains on all the screens and transitions.
        This class decides what is rendered and when.
        It also handles input communication from screens to libgdx
 */
public class ScreenManager implements ScreenChanger {
    private GameScreen activeScreen;
    private ArrayMap<String, GameScreen> screens;
    private AssetLoader assetLoader;
    public Transition curTransition;
    //Critical for back button handling
    private InputProcessor androidBackProcessor = new InputAdapter() {
        @Override
        public boolean keyDown(int keycode) {
            if (keycode == Input.Keys.BACK) {
                curScreen().back(0.25f);
            }
            return false;
        }
    };
    public InputMultiplexer inputManager = new InputMultiplexer(); //Used to manage the possible multiple input processors
    public ScreenManager() {
        screens = new ArrayMap<String, GameScreen>(); //Stores the various screens
        screens.put("Splash", new SplashScreen(this)); // Create/add the splash screen to the map
        activeScreen = screens.firstValue(); //Set the splash screen
        inputManager.addProcessor(curScreen().getStage()); //Adds the splash screen to the input processor list
        screens.put("MainMenu", new MainMenuScreen(this)); //Create/add the main menu screen
        screens.put("LevelSelect", new LevelSelectScreen(this)); //Create/add the level select screen
        screens.put("About", new AboutMenuScreen(this)); //Create/add the about screen
        screens.put("Settings", new SettingsMenuScreen(this)); //Create/add the settings screen
        screens.put("Play", new PlayScreen(this)); //Create/add the play screen
        this.curTransition = new EmptyTransition(null, null, this, 0); //This ensures that there is never a null pointer exception when referencing the transitions
        Gdx.input.setInputProcessor(this.inputManager); //Sets the input multiplexer to the processor, this does not change after this call
        Gdx.input.setCatchBackKey(true); //Allow libgdx to handle the back button press
        this.inputManager.addProcessor(androidBackProcessor); //Used to handle back button events
    }

    public GameScreen curScreen() {
        return activeScreen;
    }
    public GameScreen setCurScreen(String screenName) {
        GameScreen s;
        inputManager.removeProcessor(curScreen().getStage()); //Removes the current screen from the input multiplexer so the new screen can handle in input
        if((s = screens.get(screenName)) != null) { //Ensures the manager was not passed an invalid screen title
            activeScreen = s;
        } else {
            Gdx.app.log("ScreenManager", "Trying to add a screen that doesn't exist.");
        }
        inputManager.addProcessor(curScreen().getStage()); //Add the new screen to the multiplexer
        return activeScreen;
    }
    public GameScreen getScreen(String screenName) {
        GameScreen s;
        if((s = screens.get(screenName)) != null) { //Ensures the screenName is a valid screen in the map
            return s;
        } else {
            Gdx.app.log("ScreenManager", "Trying to get a screen that doesn't exist.");

            return null;
        }
    }
    public void dispose() { //Nothing to dispose

    }
    public void resume() {
        Gdx.input.setInputProcessor(this.inputManager);
    } //Ensures the multiplexer is always handling input
    @Override
    public void changeScreen(String screen, TransitionType transitionType, float length) { //Executes a screen change with a transition in the middle
        Gdx.input.setInputProcessor(null); //Ensures that no input is processed during the transition
        Stage before = this.curScreen().getStage(); //Screen before transition
        Stage after = getScreen(screen).getStage(); //Screen after transition
        this.curTransition = newTransition(transitionType, before, after, length); //Creates and executes the transition
        this.setCurScreen(screen); //Sets the new current screen to the after screen
    }

    @Override
    public void finishedTransition() {
        resume();
    }

    public Transition newTransition(TransitionType type, Stage before, Stage after, float length) {
        Gdx.app.log("ScreenManager", "Creating a new transition object.");
        switch(type) {
            case FADE_IN_OUT:
                return new FadeOutTransition(before, after, this, length); //Sets the current transition to a new fade transition
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
        else //When a new transition is created, the isFinished boolean is set to false making the manager render the transition instead of the screen
            this.curTransition.render(delta);
    }
}
