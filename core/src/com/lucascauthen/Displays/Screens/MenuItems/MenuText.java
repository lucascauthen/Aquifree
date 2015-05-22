package com.lucascauthen.Displays.Screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.lucascauthen.Managers.Assets.AssetEnum;
import com.lucascauthen.Managers.Assets.AssetManager;

/**
 * Created by XPS on 4/23/2015.
 */
public class MenuText  extends TextMenuItem{
    private Label textLabel;
    private Label.LabelStyle style;

    public MenuText(AssetManager assetManager, String text, Color color, int fontSize) {
        this(assetManager, text, DEFAULT_FONT, color, fontSize);
    }
    public MenuText(AssetManager assetManager, String text, String fontFile, Color color, int fontSize) {
        super(assetManager, text, fontFile, color, fontSize);
        this.style = new Label.LabelStyle();
        this.fontGenerator = (FreeTypeFontGenerator)assetManager.getAsset(fontFile, AssetEnum.FONT_GENERATOR);
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
