package com.lucascauthen.Displays.Screens.MenuItems;

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
public class MenuButton extends MenuItem{
    private Button button;
    private Skin skin;
    private Button.ButtonStyle style;
    private TextureAtlas atlas;
    private float scale = 1;
    public MenuButton(String imgAtlasFile) {
        atlas = (TextureAtlas)assetLoader.getAsset(imgAtlasFile, AssetLoader.AssetType.TEXTURE_ATLAS);
        skin = new Skin();
        skin.addRegions(atlas);
        imgAtlasFile = imgAtlasFile.substring(imgAtlasFile.lastIndexOf('/') + 1, imgAtlasFile.lastIndexOf('.'));
        style = new Button.ButtonStyle();
        style.up = skin.getDrawable(imgAtlasFile + "_UP");
        style.down = skin.getDrawable(imgAtlasFile + "_DOWN");
        button = new Button(style);
    }
    public void setScale(float scale) {
        button.setWidth(button.getWidth() * scale);
        button.setHeight(button.getHeight() * scale);
    }
    public Button getActor() {
        return button;
    }
    public void dispose() {
        skin.dispose();
    }
}
