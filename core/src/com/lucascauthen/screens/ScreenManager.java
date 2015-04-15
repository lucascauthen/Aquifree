package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lucascauthen.screens.Transitions.FadeOutInTransition;
import com.lucascauthen.screens.Transitions.Transition;
import com.lucascauthen.util.AssetLoader;

import java.util.ArrayList;
import java.util.Stack;


public class ScreenManager implements ScreenChangeListener{
    private Stack<GameScreen> activeScreens;
    private AssetLoader loader;
    public ScreenManager() {
        activeScreens = new Stack<GameScreen>();
    }
    public GameScreen curScreen() {
        if(activeScreens.empty()) {
            //Creates both the mainmenu screen and the slpashscreen and renders the splashscreen
            activeScreens.push(new MainMenuScreen(this));
            activeScreens.push(new SplashScreen(this));
            previousScreen(TransitionType.FADE_IN_OUT, 1.0f);
            Gdx.app.log("ScreenManager", "Launching splash screen and mainmenu screen.");
        }
        return activeScreens.peek();
    }
    public void dispose() {

    }
    @Override
    public void newScreen(GameScreen s, TransitionType transitionType, float length) {
        Gdx.app.log("ScreenManager", "Adding new screen: " + transitionType);
        Stage before = this.curScreen().getStage();
        this.activeScreens.push(s);
        Stage after = this.curScreen().getStage();
        this.activeScreens.push(transitionFactory(transitionType, before, after, length));
        Gdx.app.log("FadeInOut", "Starting transition.");
    }

    @Override
    public void previousScreen(TransitionType transitionType, float length) {
        if(activeScreens.size() > 1) {
            Stage before = this.curScreen().getStage();
            this.popScreen();
            Stage after = this.curScreen().getStage();
            if(!transitionType.equals(TransitionType.NONE))
                this.activeScreens.push(transitionFactory(transitionType, before, after, length));
            else
                Gdx.app.log("ScreenManager", "NONE");
        } else {
            Gdx.app.log("ScreenManager", "Cannot transition to previous screen because there is only one screen in the stack.");
        }

    }
    public Transition transitionFactory(TransitionType type, Stage before, Stage after, float length) {
        Gdx.app.log("ScreenManager", "Creating a new transition object.");
        switch(type) {
            case FADE_IN_OUT:
                return new FadeOutInTransition(before, after, length, this);
            case PAN_LEFT:
                //Add later
            case PAN_RIGHT:
                //Add later
            default:
                return new FadeOutInTransition(before, after, 0.5f, this);
        }
    }
    public void render(float delta) {
        this.curScreen().render(delta);
    }
    public void popScreen() {
        this.activeScreens.pop();
    }
}
