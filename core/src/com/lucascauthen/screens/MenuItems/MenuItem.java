package com.lucascauthen.screens.MenuItems;

import com.lucascauthen.components.AssetLoaderComponent;

import com.lucascauthen.util.AssetLoader;




/**
 * Created by XPS on 5/14/2015.
 */
public abstract class MenuItem {
    protected AssetLoader assetLoader;
    public abstract void dispose();
    public MenuItem() {
        AssetLoaderComponent component = DaggerAssetLoaderComponent.create();
        assetLoader = component.provideAssetLoader();
    }
}
