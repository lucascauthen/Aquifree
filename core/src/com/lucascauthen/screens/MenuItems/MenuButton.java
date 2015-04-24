package com.lucascauthen.screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/14/2015.
 */
public class MenuButton {
    TextButton button;
    Skin skin;
    TextButton.TextButtonStyle style;
    TextureAtlas atlas;
    BitmapFont font;
    public MenuButton(String text, Color color) {
        font = (BitmapFont)AssetLoader.getInstance().getAsset("Fonts/MenuFont35.fnt", AssetLoader.AssetType.BITMAPFONT);
        skin = new Skin();
        atlas = (TextureAtlas)AssetLoader.getInstance().getAsset("Buttons/Button_Large.atlas", AssetLoader.AssetType.TEXTURE_ATLAS);
        skin.addRegions(atlas);
        style = new TextButton.TextButtonStyle();
        style.font = font;
        style.fontColor = color;
        style.up = skin.getDrawable("Button_Large");
        style.down = skin.getDrawable("Button_Large_Active");
        button = new TextButton(text, style);
    }

    public TextButton getActor() {
        return button;
    }
}
