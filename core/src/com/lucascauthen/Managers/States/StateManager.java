package com.lucascauthen.Managers.States;

import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.Input.InputManager;
import com.lucascauthen.Managers.Levels.LevelManager;
import com.lucascauthen.Managers.Sound.SoundManager;

import java.util.LinkedList;

/**
 * Created by Administrator on 5/21/2015.
 */
public class StateManager {
    public final ScreenManager screenManager;
    public final SoundManager soundManager;
    public final LevelManager levelManager;
    public final InputManager inputManager;

    private final LinkedList<Event> eventQueue = new LinkedList<Event>();

    public StateManager(ScreenManager screenManager, SoundManager soundManager, LevelManager levelManager, InputManager inputManager) {
        this.screenManager = screenManager;
        this.soundManager = soundManager;
        this.levelManager = levelManager;
        this.inputManager = inputManager;
        screenManager.registerStateManager(this);
        screenManager.init();
    }
    public void update(float delta) {
        executeEvents();
    }
    public void addEvent(EventEnum type, Object... params) {
        eventQueue.addLast(new Event(type, params));
    }
    private void executeEvents() {
        while(eventQueue.size() > 0) {
            Event e = eventQueue.getFirst();
            e.getEvent().execute(this, e.getParams());
            eventQueue.removeFirst();
        }
    }

}
