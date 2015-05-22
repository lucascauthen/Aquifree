package com.lucascauthen.Managers.Assets;

import com.badlogic.gdx.utils.Disposable;

/**
 * Created by XPS on 4/12/2015.
 */
/*
    Purpose: Serves as a wrapper to the disposable class (libgdx)
 */
public class DisposableAsset {
    public Disposable getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public AssetEnum getType() {
        return type;
    }

    private AssetEnum type;
    private Disposable item;
    private String name;
    private int id;
    public DisposableAsset(Disposable item, String name, int id, AssetEnum type) {
        this.item = item;
        this.name = name;
        this.id = id;
        this.type = type;
    }
}
