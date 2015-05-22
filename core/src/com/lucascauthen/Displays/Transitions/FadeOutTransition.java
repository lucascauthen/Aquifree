package com.lucascauthen.Displays.Transitions;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucascauthen.Managers.States.StateManager;


public class FadeOutTransition extends Transition {

    public FadeOutTransition(StateManager stateManger, SpriteBatch before, SpriteBatch after, float length, Object... params) {
        super(stateManger, before, after, length, params);
    }

    @Override
    public void draw() {

    }

    @Override
    public void act() {

    }
}
