package com.lucascauthen.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public interface ScreenChangeListener {
    void newScreen(GameScreen s);
    void popCurScreen();
    void popCurScreenWithoutFade();
}
