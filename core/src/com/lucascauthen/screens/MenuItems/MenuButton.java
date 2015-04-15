package com.lucascauthen.screens.MenuItems;

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
    public MenuButton(String text) {
        font = (BitmapFont)AssetLoader.getInstance().getAsset("Fonts/MenuFont.fnt", AssetLoader.AssetType.BITMAPFONT);
        skin = new Skin();
        atlas = (TextureAtlas)AssetLoader.getInstance().getAsset("Buttons/Button_Regular.atlas", AssetLoader.AssetType.TEXTURE_ATLAS);
        skin.addRegions(atlas);
        style = new TextButton.TextButtonStyle();
        style.font = font;
        style.up = skin.getDrawable("Button_Regular");
        style.down = skin.getDrawable("Button_Regular_Active");
        button = new TextButton(text, style);
    }

    public TextButton get() {
        return button;
    }
}
