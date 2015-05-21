package com.lucascauthen.Displays.Screens.MenuItems;

import com.lucascauthen.util.AssetLoader;

import javax.inject.Inject;


/**
 * Created by XPS on 5/14/2015.
 */
public abstract class MenuItem {
    @Inject
    public AssetLoader assetLoader;
    public abstract void dispose();
    //ObjectGraph objectGraph = ObjectGraph.create(new AssetLoaderModule());

    public MenuItem() {
        this.assetLoader= new AssetLoader();
    }
}
