package com.lucascauthen.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

/**
 * Created by Administrator on 4/7/2015.
 */
/*
    Purpose: Manages all libgdx disposable assets.
        Ensures that there are never duplicate assets created.
        Ensures that assets aren't disposed of prematurely
        Helps reduce overhead by allowing different screens with identical assets to share such assets without duplication


    Structure Note: This class is a singleton, meaning that it is a global class that can only have one instance.

    NOTE:
        After the addition of the freetype font generator, this class no longer has functionality for managing BITMAP fonts
        This will be added soon.
 */
public class AssetLoader {
    private ArrayList<Asset> assetList = new ArrayList<Asset>();
    private int curId;
    private int nextId(){
        return ++curId;
    }
    public Disposable getAsset(String fileName, AssetType type) {
        FileHandle file = Gdx.files.internal(fileName);
        if(file.exists()) {
            for(Asset asset: this.assetList) {
                if(asset.getName().equals(fileName) && asset.getType().equals(type)) {
                    return asset.getItem();
                }
            }
            //Hasn't been loaded already so please load it now
            return loadAsset(fileName, type);
        }
        //Returns null if there is no matching asset and no matching file with that name
        Gdx.app.log("Assets", "File with name: " + fileName + " was requested but does not exist.");
        return null;
    }
    private Disposable loadAsset(String fileName, AssetType type) {
        switch(type) {
            case TEXTURE:
                assetList.add(new Asset(new Texture(Gdx.files.internal(fileName)), fileName, nextId(), type));
                return getLatestItem();
            case BITMAPFONT:
                assetList.add(new Asset(new BitmapFont(Gdx.files.internal(fileName)), fileName, nextId(), type));
                return getLatestItem();
            case TEXTURE_ATLAS:
                assetList.add(new Asset(new TextureAtlas(Gdx.files.internal(fileName)), fileName, nextId(), type));
                return getLatestItem();
            case FONT_GENERATOR:
                assetList.add(new Asset(new FreeTypeFontGenerator(Gdx.files.internal(fileName)), fileName, nextId(), type));
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
        TEXTURE_ATLAS,
        FONT_GENERATOR
    }
}
