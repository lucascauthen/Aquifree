package com.lucascauthen.components;

import com.lucascauthen.util.AssetLoader;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 5/19/2015.
 */
@Singleton
@Component(modules = {AssetLoader.class})
public interface AssetLoaderComponent {
    AssetLoader provideAssetLoader();
}
