package com.lucascauthen.screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by XPS on 5/14/2015.
 */

/*
    IMPORTANT:
    If you use this constructor, the names of the up state and down state have to follow the pattern -

        UP: [imgFile]_UP
        DOWN: [imgFile]_DOWN

    Example:

        file: Buttons/Settings.atlas
        UP name: Settings_UP
        DOWN name: Settings_DOWN

*/
public class TextMenuButton extends TextMenuItem{
    private Button button;
    private Skin skin;
    private TextButton.TextButtonStyle style;
    private TextureAtlas atlas;
    public TextMenuButton(String imgFile, String text, Color fontColor, int fontSize) {
        this(imgFile, DEFAULT_FONT, text, fontColor, fontSize);
    }
    public TextMenuButton(String text, String fontFile, String imgFile, Color fontColor, int fontSize) {
        super(text, fontFile, fontColor, fontSize);
        atlas = (TextureAtlas) AssetLoader.getInstance().getAsset(imgFile, AssetLoader.AssetType.TEXTURE_ATLAS);
        skin = new Skin();
        skin.addRegions(atlas);
        imgFile = imgFile.substring(imgFile.lastIndexOf('/'), imgFile.lastIndexOf('.'));
        style = new TextButton.TextButtonStyle();
        style.up = skin.getDrawable(imgFile + "_UP");
        style.down = skin.getDrawable(imgFile + "_DOWN");
        button = new TextButton(this.getText(), style);
    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
    }
}
