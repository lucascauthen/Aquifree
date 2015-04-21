package com.lucascauthen.screens;

/**
 * Created by Administrator on 4/7/2015.
 */
public interface ScreenChanger {
    void changeScreen(String screen, ScreenManager.TransitionType transitionType, float length);
    void finishedTransition();
    public enum TransitionType {
        FADE_IN_OUT,
        PAN_LEFT,
        PAN_RIGHT,
        NONE
    }
}
