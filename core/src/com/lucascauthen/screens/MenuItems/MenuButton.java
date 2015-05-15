package com.lucascauthen.screens.MenuItems;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.lucascauthen.util.AssetLoader;

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
public class MenuButton {
    private Button button;
    private Skin skin;
    private Button.ButtonStyle style;
    private TextureAtlas atlas;
    public MenuButton(String imgFile) {
        atlas = (TextureAtlas)AssetLoader.getInstance().getAsset(imgFile, AssetLoader.AssetType.TEXTURE_ATLAS);
        skin = new Skin();
        skin.addRegions(atlas);
        imgFile = imgFile.substring(imgFile.lastIndexOf('/'), imgFile.lastIndexOf('.'));
        style = new Button.ButtonStyle();
        style.up = skin.getDrawable(imgFile + "_UP");
        style.down = skin.getDrawable(imgFile + "_DOWN");
        button = new Button(style);
    }
    public Button getActor() {
        return button;
    }
    public void dispose() {
        skin.dispose();
    }
}
