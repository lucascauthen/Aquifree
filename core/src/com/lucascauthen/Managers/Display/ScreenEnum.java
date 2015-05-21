package com.lucascauthen.Managers.Display;

import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.Screens.LevelScreen;
import com.lucascauthen.Displays.Screens.SplashScreen;

/**
 * Created by Administrator on 5/21/2015.
 */
public enum ScreenEnum {
    MAIN_MENU {
        public TransitionableScreen getScreen(Object... params) {
            return null;
        };
    },
    ABOUT_MENU {
        public TransitionableScreen getScreen(Object... params) {
            return null;
        };
    },
    SETTINGS_MENU {
        public TransitionableScreen getScreen(Object... params) {
            return null;
        };
    },
    SPLASH {
        public TransitionableScreen getScreen(Object... params) {
            return new SplashScreen();
        };
    },
    LEVEL_MENU {
        public TransitionableScreen getScreen(Object... params) {
            return null;
        };
    },
    PLAY_SCREEN {
        public TransitionableScreen getScreen(Object... params) {
            return new LevelScreen((Integer)params[0]);
        };
    },
    STAT_MENU {
        public TransitionableScreen getScreen(Object... params) {
            return null;
        };
    };
    public abstract TransitionableScreen getScreen(Object...params);
}
