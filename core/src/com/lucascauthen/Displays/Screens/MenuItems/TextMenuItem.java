package com.lucascauthen.Displays.Screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.lucascauthen.Managers.Assets.AssetManager;

/**
 * Created by XPS on 5/14/2015.
 */
public abstract class TextMenuItem extends MenuItem{
    protected static final String DEFAULT_FONT = "Fonts/blocked.ttf";
    protected BitmapFont font;
    protected FreeTypeFontGenerator fontGenerator;
    protected FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
    protected String text;
    public TextMenuItem(AssetManager assetManager, String text, String fontFile, Color color, int fontSize) {
        super(assetManager);
        this.setFontColor(color);
        this.setFontSize(fontSize);
        this.setText(text);
    }
    public void setText(String text) {
        this.text = text;
    }

    public void setFontColor(Color fontColor) {
        this.parameters.color = fontColor;
    }

    public void setFontSize(int fontSize) {
        this.parameters.size = fontSize;
    }

    public int getFontSize() {

        return this.parameters.size;
    }

    public Color getFontColor() {
        return this.parameters.color;
    }

    public String getText() {
        return text;
    }
    public BitmapFont updateText() {
        if(fontGenerator != null) {
            this.font = fontGenerator.generateFont(parameters);
        }
        return this.font;
    }
    @Override
    public void dispose() {
        font.dispose();
    }

}
