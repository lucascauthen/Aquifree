package com.lucascauthen.Displays.Screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.lucascauthen.Managers.Assets.AssetEnum;
import com.lucascauthen.Managers.Assets.AssetManager;

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
    public TextMenuButton(AssetManager assetManager, String imgAtlasFile, String text, Color fontColor, int fontSize) {
        this(assetManager, imgAtlasFile, DEFAULT_FONT, text, fontColor, fontSize);
    }
    public TextMenuButton(AssetManager assetManager, String text, String fontFile, String imgAtlasFile, Color fontColor, int fontSize) {
        super(assetManager, text, fontFile, fontColor, fontSize);
        atlas = (TextureAtlas)assetManager.getAsset(imgAtlasFile, AssetEnum.TEXTURE_ATLAS);
        skin = new Skin();
        skin.addRegions(atlas);
        imgAtlasFile = imgAtlasFile.substring(imgAtlasFile.lastIndexOf('/'), imgAtlasFile.lastIndexOf('.'));
        style = new TextButton.TextButtonStyle();
        style.up = skin.getDrawable(imgAtlasFile + "_UP");
        style.down = skin.getDrawable(imgAtlasFile + "_DOWN");
        style.font = updateText();

        button = new TextButton(this.getText(), style);
    }

    @Override
    public void dispose() {
        super.dispose();
        skin.dispose();
    }
}
