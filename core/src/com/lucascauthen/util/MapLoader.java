package com.lucascauthen.util;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by Administrator on 4/24/2015.
 */
public class MapLoader {
    private TiledMap map;
    private static MapLoader instance;
    public static MapLoader getInstance() {
        if(instance == null) {
            instance = new MapLoader();
        }
        return instance;
    }
    public TiledMap loadMap(String fileName) {
        if(map != null) {
            map.dispose();
        }
        return map = new TmxMapLoader().load(fileName);
    }
    private MapLoader() {

    }
}
