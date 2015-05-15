package com.lucascauthen.screens.MenuItems;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/14/2015.
 */
public class MenuButton {
    private Button button;
    private Skin skin;
    private TextButton.TextButtonStyle styleWithText;
    private Button.ButtonStyle styleWithoutText;
    private TextureAtlas atlas;
    private BitmapFont font;
    public MenuButton(String text, Color textColor) { //Loads a menu button with text and a specific color
        font = (BitmapFont)AssetLoader.getInstance().getAsset("Fonts/MenuFont35.fnt", AssetLoader.AssetType.BITMAPFONT);
        skin = new Skin();
        atlas = (TextureAtlas)AssetLoader.getInstance().getAsset("Buttons/Button_Large.atlas", AssetLoader.AssetType.TEXTURE_ATLAS);
        skin.addRegions(atlas);
        styleWithText = new TextButton.TextButtonStyle();
        styleWithText.font = font;
        styleWithText.fontColor = textColor;
        styleWithText.up = skin.getDrawable("Button_Large");
        styleWithText.down = skin.getDrawable("Button_Large_Active");
        button = new TextButton(text, styleWithText);
    }
    /*
        IMPORTANT:
        If you use this constructor, the names of the up state and down state have to follow the pattern -

            UP: [filename]_UP
            DOWN: [filename]_DOWN

        Example:

            file: Buttons/Settings.atlas
            UP name: Settings_UP
            DOWN name: Settings_DOWN

    */
    public MenuButton(String fileName) {
        atlas = (TextureAtlas)AssetLoader.getInstance().getAsset(fileName, AssetLoader.AssetType.TEXTURE_ATLAS);
        skin = new Skin();
        skin.addRegions(atlas);
        fileName = fileName.substring(fileName.lastIndexOf('/'), fileName.lastIndexOf('.'));
        styleWithoutText = new Button.ButtonStyle();
        styleWithoutText.up = skin.getDrawable(fileName + "_UP");
        styleWithoutText.down = skin.getDrawable(fileName + "_DOWN");
        button = new Button(styleWithoutText);
    }
    public MenuButton(String fileName, String text, int fontSize) {

    }
    public Button getActor() {
        return button;
    }
}
