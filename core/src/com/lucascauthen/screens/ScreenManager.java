package com.lucascauthen.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Screen;
import com.lucascauthen.auqifree.ScreenChanger;
import com.lucascauthen.util.AssetLoader;
import java.util.Stack;


public class ScreenManager implements ScreenChangeListener{
    private Stack<Screen> screens;
    private AssetLoader loader;
    public ScreenManager() {
        screens = new Stack<Screen>();
    }
    public Screen curScreen() {
        if(screens.empty()) {
            screens.push(new MainMenuScreen(this));
        }
        return screens.peek();
    }
    public void dispose() {

    }
    @Override
    public void newScreen(GameScreen s) {
        screens.push(s);
    }

    @Override
    public void popCurScreen() {

        screens.pop();
    }
    public void render(float delta) {
        this.curScreen().render(delta);
    }
}
