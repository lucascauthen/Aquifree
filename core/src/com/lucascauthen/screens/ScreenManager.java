package com.lucascauthen.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Screen;
import com.lucascauthen.auqifree.ScreenChanger;
import com.lucascauthen.util.AssetLoader;
import java.util.Stack;


public class ScreenManager implements ScreenChangeListener{
    private Stack<GameScreen> screens;
    private AssetLoader loader;
    public ScreenManager() {
        screens = new Stack<GameScreen>();
    }
    public Screen curScreen() {
        if(screens.empty()) {
            //Creates both the mainmenu screen and the slpashscreen and renders the splashscreen
            screens.push(new MainMenuScreen(this));
            GameScreen temp = screens.peek();
            screens.push(new SplashScreen(this, temp));
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
        this.curScreen().resume();
    }
    public void popCurScreenWithoutFade() {
        screens.pop();
    }
    public void render(float delta) {
        this.curScreen().render(delta);
    }
}
