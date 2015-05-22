package com.lucascauthen.Managers.Levels;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.lucascauthen.Managers.States.StateManager;

/**
 * Created by Administrator on 5/21/2015.
 */
public class LevelManager {

    Map loadedLevel;
    boolean isLoaded = false;

    public LevelManager() {

    }

    public void loalLevel(String fileName) {
        TiledMap tiledMap = new TmxMapLoader().load(fileName);
    }

    public void unLoadLevel() {
        this.loadedLevel.dispose();
        isLoaded = false;
    }

    public Map getLevel() {
        assert isLoaded;
        return this.loadedLevel;
    }
}
