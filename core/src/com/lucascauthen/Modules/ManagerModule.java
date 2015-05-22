package com.lucascauthen.Modules;

import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.Screens.SplashScreen;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.Input.InputManager;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.Sound.SoundManager;
import com.lucascauthen.Managers.States.StateManager;
import com.lucascauthen.auqifree.AquifreeGame;
import com.lucascauthen.util.Tester;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 5/21/2015.
 */
@Module (
        injects = {
                AquifreeGame.class,
                Tester.class
        }
)
public class ManagerModule extends  Object{
    @Provides
    @Singleton
    public InputManager provideInputManager() {
        return new InputManager();
    }
    @Provides
    @Singleton
    public ScreenManager provideScreenManager(AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
        return new ScreenManager(assetManager, levelManager, soundManager);
    }
    @Provides
    @Singleton
    public AssetManager provideAssetManager() {
        return new AssetManager();
    }
    @Provides
    @Singleton
    public SoundManager provideSoundManager() {
        return new SoundManager();
    }

    @Provides
    @Singleton
    public StateManager provideStateManager(ScreenManager screenManager, SoundManager soundManager, LevelManager levelManager, InputManager inputManager) {
        return new StateManager(screenManager, soundManager, levelManager, inputManager);
    }
    @Provides
    @Singleton
    public LevelManager provideLevelManager() {
        return new LevelManager();
    }
}
