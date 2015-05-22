package com.lucascauthen.Managers.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Administrator on 5/22/2015.
 */
public enum AssetEnum {
    TEXTURE{
        public Disposable getAsset(String fileName) {
            return new Texture(Gdx.files.internal(fileName));
        }
    },
    BITMAP_FONT{
        public Disposable getAsset(String fileName) {
            return new BitmapFont(Gdx.files.internal(fileName));
        }
    },
    TEXTURE_ATLAS{
        public Disposable getAsset(String fileName) {
            return new TextureAtlas(Gdx.files.internal(fileName));
        }
    },
    FONT_GENERATOR{
        public Disposable getAsset(String fileName) {
            return new FreeTypeFontGenerator(Gdx.files.internal(fileName));
        }
    };
    public abstract Disposable getAsset(String fileName);
}
