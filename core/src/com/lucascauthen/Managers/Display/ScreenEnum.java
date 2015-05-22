package com.lucascauthen.Managers.Display;

import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.Screens.LevelScreen;
import com.lucascauthen.Displays.Screens.SplashScreen;
import com.lucascauthen.Managers.Assets.AssetManager;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.Sound.SoundManager;
import com.lucascauthen.Managers.States.StateManager;

/**
 * Created by Administrator on 5/21/2015.
 */
public enum ScreenEnum {
    MAIN_MENU {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return null;
        };
    },
    ABOUT_MENU {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return null;
        };
    },
    SETTINGS_MENU {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return null;
        };
    },
    SPLASH {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return new SplashScreen(stateManager, assetManager, levelManager, soundManager);
        };
    },
    LEVEL_MENU {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return null;
        };
    },
    PLAY_SCREEN {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return new LevelScreen(stateManager, assetManager, levelManager, soundManager);
        };
    },
    STAT_MENU {
        public TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager) {
            return null;
        };
    };
    public abstract TransitionableScreen getScreen(StateManager stateManager, AssetManager assetManager, LevelManager levelManager, SoundManager soundManager);
}
