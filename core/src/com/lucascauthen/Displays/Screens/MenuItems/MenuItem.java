package com.lucascauthen.Displays.Screens.MenuItems;

import com.lucascauthen.Managers.Assets.AssetManager;


import javax.inject.Inject;


/**
 * Created by XPS on 5/14/2015.
 */
public abstract class MenuItem {
    public abstract void dispose();
    //ObjectGraph objectGraph = ObjectGraph.create(new AssetLoaderModule());
    private final AssetManager assetManager;
    public MenuItem(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
}
