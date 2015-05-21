package com.lucascauthen.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.lucascauthen.Game.Entities.Entity;
import com.lucascauthen.util.MapLoader;

import java.util.ArrayList;

/**
 * Created by Administrator on 4/24/2015.
 */
public class Map {
    ArrayList<Entity> entities = new ArrayList<Entity>();
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;
    TiledMap map;
    public Map() {
        this("Maps/Level1.tmx");
    }
    public Map(String mapName) {
        this.map = MapLoader.getInstance().loadMap(mapName);
        entities = new ArrayList<Entity>();
        for(MapObject object : ((MapLayer)this.map.getLayers().get("Objects")).getObjects()) {
            entities.add(new Entity(object));
        }
    }
    public void render() {
        for(Entity entity : entities) {
            entity.render();
        }
    }
    public void act(float delta) {
        for(Entity entity : entities) {
            entity.update(delta);
        }
    }
    public void dispose() {

    }
}
