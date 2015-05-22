package com.lucascauthen.Managers.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

/**
 * Created by Administrator on 5/20/2015.
 */
public class AssetManager {
    private ArrayList<DisposableAsset> disposableAssetList = new ArrayList<DisposableAsset>();
    private int curId;
    private int nextId(){
        return ++curId;
    }
    public Disposable getAsset(String fileName, AssetEnum type) {
        FileHandle file = Gdx.files.internal(fileName);
        if(file.exists()) {
            for(DisposableAsset disposableAsset : this.disposableAssetList) {
                if(disposableAsset.getName().equals(fileName) && disposableAsset.getType().equals(type)) {
                    return disposableAsset.getItem();
                }
            }
            //Hasn't been loaded already so please load it now
            return loadAsset(fileName, type);
        }
        //Returns null if there is no matching asset and no matching file with that name
        Gdx.app.log("Assets", "File with name: " + fileName + " was requested but does not exist.");
        return null;
    }
    public Disposable loadAsset(String filename, AssetEnum type) {
        Disposable asset = type.getAsset(filename);
        disposableAssetList.add(new DisposableAsset(asset, filename, nextId(), type));
        return getLatestItem();
    }
    public void disposeAll() {
        for(DisposableAsset disposableAsset : disposableAssetList) {
            disposableAsset.getItem().dispose();
        }
        disposableAssetList.clear();
    }
    public void dispose(String filename) {
        for(DisposableAsset asset : disposableAssetList) {
            if(asset.getName().equals(filename)) {
                asset.getItem().dispose();
                disposableAssetList.remove(disposableAssetList.indexOf(asset)); //Removes the asset with,  yes probably not the most efficient
            }
        }
    }
    private Disposable getLatestItem() {
        return disposableAssetList.get(disposableAssetList.size() - 1).getItem();
    }
}
