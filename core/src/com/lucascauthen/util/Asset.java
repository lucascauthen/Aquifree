package com.lucascauthen.util;

import com.badlogic.gdx.utils.Disposable;

/**
 * Created by XPS on 4/12/2015.
 */
public class Asset {
    public Disposable getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public AssetLoader.AssetType getType() {
        return type;
    }

    private AssetLoader.AssetType type;
    private Disposable item;
    private String name;
    private int id;
    public Asset(Disposable item, String name, int id, AssetLoader.AssetType type) {
        this.item = item;
        this.name = name;
        this.id = id;
        this.type = type;
    }
}
