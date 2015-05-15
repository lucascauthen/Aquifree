package com.lucascauthen.Game.Entities;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.ArrayMap;

/**
 * Created by Administrator on 4/24/2015.
 */
public class Entity {
    protected MapObject object;
    protected MapProperties properties;
    public float getX() {
        return Float.parseFloat(properties.get("X").toString());
    }
    public float getY() {
        return Float.parseFloat(properties.get("Y").toString());
    }
    public Entity(MapObject object) {
        this.object = object;
        properties = object.getProperties();
    }
    public void update(float delta) {

    }
    public void render() {

    }
}
