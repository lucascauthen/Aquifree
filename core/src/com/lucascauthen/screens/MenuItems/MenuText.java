package com.lucascauthen.screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by XPS on 4/23/2015.
 */
public class MenuText  extends TextMenuItem{
    private Label textLabel;
    private Label.LabelStyle style;

    public MenuText(String text, Color color, int fontSize) {
        this(text, DEFAULT_FONT, color, fontSize);
    }
    public MenuText(String text, String fontFile, Color color, int fontSize) {
        super(text, fontFile, color, fontSize);
        this.style = new Label.LabelStyle();
        this.fontGenerator = (FreeTypeFontGenerator)assetLoader.getAsset(fontFile, AssetLoader.AssetType.FONT_GENERATOR);
        this.parameters.color = color;
        this.text = text;
        this.parameters.size = fontSize;
        style.font = updateText();
        style.fontColor = color;
        this.textLabel = new Label(text, style);
    }
    public Label getActor() {
        return textLabel;
    }
}
