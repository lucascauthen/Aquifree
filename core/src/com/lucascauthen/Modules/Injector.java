package com.lucascauthen.Modules;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class Injector {

    private static Injector injector;
    private ObjectGraph objectGraph;

    private Injector() {

    }

    public static Injector getInstance() {
        if (injector == null) {
            injector = new Injector();
            injector.initialize();
        }
        return injector;
    }

    protected List<Object> getModules() {
        return Arrays.asList((Object) new ManagerModule());

    }

    public void inject(Object object) {
        getObjectGraph().inject(object);
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    public void initialize() {
        objectGraph = ObjectGraph.create(getModules().toArray());
        System.out.println(String.format("init object graph = %s", objectGraph.toString()));
    }
}