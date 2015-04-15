package com.lucascauthen.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.lucascauthen.util.AssetLoader;
import com.lucascauthen.screens.ScreenManager;

/**
 * Created by Administrator on 4/7/2015.
 */
public interface ScreenChangeListener {
    void newScreen(GameScreen s, ScreenManager.TransitionType transitionType, float length);
    void previousScreen(ScreenManager.TransitionType transitionType, float length);
    public enum TransitionType {
        FADE_IN_OUT,
        PAN_LEFT,
        PAN_RIGHT,
        NONE
    }
}
