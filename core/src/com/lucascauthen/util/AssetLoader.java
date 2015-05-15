package com.lucascauthen.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

/**
 * Created by Administrator on 4/7/2015.
 */
public class AssetLoader {
    private ArrayList<Asset> assetList = new ArrayList<Asset>();
    private static AssetLoader assetLoader;
    private AssetLoader() {
        this.assetList = new ArrayList<Asset>();
    }
    public static AssetLoader getInstance() {
        if(assetLoader == null) {
            assetLoader = new AssetLoader();
        }
        return assetLoader;
    }
    private int curId;
    private int nextId(){
        return ++curId;
    }
    public Disposable getAsset(String name, AssetType type) {
        FileHandle file = Gdx.files.internal(name);
        if(file.exists()) {
            for(Asset asset: this.assetList) {
                if(asset.getName().equals(name)) {
                    return asset.getItem();
                }
            }
            //Hasn't been loaded already so please load it now
            return loadAsset(name, type);
        }
        //Returns null if there is no matching asset and no matching file with that name
        Gdx.app.log("Assets", "File with name: " + name + " was requested but does not exist.");
        return null;
    }
    private Disposable loadAsset(String name, AssetType type) {
        switch(type) {
            case TEXTURE:
                assetList.add(new Asset(new Texture(Gdx.files.internal(name)), name, nextId(), type));
                return getLatestItem();
            case BITMAPFONT:
                assetList.add(new Asset(new BitmapFont(Gdx.files.internal(name)), name, nextId(), type));
                return getLatestItem();
            case TEXTURE_ATLAS:
                assetList.add(new Asset(new TextureAtlas(Gdx.files.internal(name)), name, nextId(), type));
                return getLatestItem();
            default:
                Gdx.app.log("Assets", "File of type: " + type + " cannot be loaded because it is an invalid type.");
                return null;
        }
    }
    private Disposable getLatestItem() {
        return assetList.get(assetList.size() - 1).getItem();
    }
    public void dispose(String name) {

    }
    public void disposeAll() {
        for(Asset asset: assetList) {
            asset.getItem().dispose();
        }
        assetList.clear();
    }
    public enum AssetType {
        TEXTURE,
        BITMAPFONT,
        TEXTURE_ATLAS
    }
}
