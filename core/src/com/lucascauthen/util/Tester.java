package com.lucascauthen.util;

import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.States.StateManager;
import com.lucascauthen.Modules.Injector;

import javax.inject.Inject;

/**
 * Created by Administrator on 5/22/2015.
 */
public class Tester {

    @Inject
    public ScreenManager screenManager;
    @Inject
    public StateManager stateManager;
    public Tester() {
        Injector.getInstance().inject(this);
    }
}
