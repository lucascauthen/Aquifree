package com.lucascauthen.screens;

import com.badlogic.gdx.Screen;
import com.lucascauthen.auqifree.ScreenChanger;
import com.lucascauthen.util.AssetLoader;
import java.util.Stack;


public class ScreenManager implements ScreenChangeListener{
    private Stack<Screen> screens;
    private AssetLoader loader;
    private ScreenChanger parent;
    public ScreenManager(ScreenChanger parent) {
        screens = new Stack<Screen>();
        this.parent = parent;
    }
    public Screen curScreen() {
        if(screens.peek() == null) {
            screens.push(new MainMenuScreen(this));
        }
        return screens.peek();
    }
    public void dispose() {

    }
    public void updateCurScreen() {
        this.parent.changeScreen(curScreen());
    }
    @Override
    public void newScreen(GameScreen s) {
        screens.push(s);
    }

    @Override
    public void popCurScreen() {
        screens.pop();
    }
    public void render() {
        this.screens.peek().render();
    }
}
