package com.lucascauthen.Managers.Display;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lucascauthen.Displays.BaseDisplays.TransitionDisplay;
import com.lucascauthen.Managers.States.StateManager;

/**
 * Created by Administrator on 5/21/2015.
 */
public enum TransitionEnum {
    FADE_IN_OUT {
        public TransitionDisplay getTransition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params) {
            return null;
        };
    },
    PAN_LEFT {
        public TransitionDisplay getTransition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params) {
            return null;
        };
    },
    PAN_RIGHT {
        public TransitionDisplay getTransition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params) {
            return null;
        };
    },
    NONE {
        public TransitionDisplay getTransition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params) {
            return null;
        };
    };
    public abstract TransitionDisplay getTransition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params);
}
