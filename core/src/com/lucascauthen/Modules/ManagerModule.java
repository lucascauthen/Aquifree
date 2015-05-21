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

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 5/21/2015.
 */
@Module (
        injects = {
                AquifreeGame.class
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
    public ScreenManager provideScreenManager(InputManager inputManager, AssetManager assetManager, StateManager stateManager, LevelManager levelManager) {
        return new ScreenManager(inputManager, assetManager, stateManager, levelManager);
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
}
