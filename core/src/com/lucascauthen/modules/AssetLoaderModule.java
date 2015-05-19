package com.lucascauthen.modules;
/**
 * Created by Administrator on 5/18/2015.
 */

import com.lucascauthen.util.AssetLoader;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AssetLoaderModule {
    @Provides @Singleton
    AssetLoader provideAssetLoader() {
        return new AssetLoader();
    }
}
