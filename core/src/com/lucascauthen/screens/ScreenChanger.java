package com.lucascauthen.screens;

/**
 * Created by Administrator on 4/7/2015.
 */
/*
    Purpose: Facilitates communication of a screen change from the current screen to the screen manager
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
