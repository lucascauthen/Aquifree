package com.lucascauthen.Managers.States;

import com.lucascauthen.Managers.Display.ScreenEnum;
import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.Display.TransitionEnum;

/**
 * Created by Administrator on 5/22/2015.
 */
public enum EventEnum {
    SCREEN_CHANGE {
        public void execute(StateManager stateManager, Object... params) {
            /*
            [0] - Screen to transtion to
            [1] - Transtion to play
            [2] - transtion time
            */
            ScreenEnum screen = (ScreenEnum)params[1];
            TransitionEnum transition = (TransitionEnum)params[2];
            float duration = (Float)params[3];
        }
    },
    SCREEN_CHANGE_WITHOUT_TRANSTION {
        public void execute(StateManager stateManager, Object... params) {
            /*
            [0] - Screen to transtion to
            */
            ScreenEnum screen = (ScreenEnum)params[0];
            stateManager.screenManager.changeScreen(screen);
        }
    };
    public abstract void execute(StateManager stateManager, Object... parms);
}
