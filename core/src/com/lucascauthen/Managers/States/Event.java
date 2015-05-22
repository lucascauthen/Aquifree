package com.lucascauthen.Managers.States;

/**
 * Created by Administrator on 5/22/2015.
 */
public class Event {
    private final EventEnum event;
    private final Object[] params;

    public Event(EventEnum event, Object... params) {
        this.event = event;
        this.params = params;
    }

    public EventEnum getEvent() {
        return event;
    }

    public Object[] getParams() {
        return params;
    }
}
