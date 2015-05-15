package com.lucascauthen.screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by XPS on 4/23/2015.
 */
public class MenuText  {
    Label text;
    Label.LabelStyle style;
    BitmapFont font;
    public MenuText(String text, String fontFile, Color color) {
        this.style = new Label.LabelStyle();
        this.font = (BitmapFont) AssetLoader.getInstance().getAsset(fontFile, AssetLoader.AssetType.BITMAPFONT);
        style.font = font;
        style.fontColor = color;
        this.text = new Label(text, style);
    }
    public Label getActor() {
        return text;
    }
}
