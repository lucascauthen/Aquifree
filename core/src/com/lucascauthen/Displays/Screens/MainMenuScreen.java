package com.lucascauthen.Displays.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lucascauthen.Displays.BaseDisplays.StageDisplay;
import com.lucascauthen.Displays.BaseDisplays.TransitionableScreen;
import com.lucascauthen.Displays.BaseDisplays.UiScreen;
import com.lucascauthen.Displays.Screens.MenuItems.MenuButton;
import com.lucascauthen.Modules.Injector;

import javax.inject.Inject;

/**
 * Created by Administrator on 4/7/2015.
 */
public class MainMenuScreen extends TransitionableScreen implements UiScreen {
    @Inject
    public StageDisplay stageDisplay;

    private final float PADDING = 15f;
    MenuButton playButton;
    MenuButton aboutButton;
    MenuButton settingsButton;


    Image backgroundImage;
    Texture backgroundTexture;
    Table backgroundContents;

    public MainMenuScreen() {
        Injector.getInstance().inject(this);
    }


    @Override
    public SpriteBatch getSnapShot() {
        return null;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {


    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void loadUi() { /*
        backgroundContents = new Table();
        backgroundContents.setDebug(true);
        backgroundTexture = (Texture)assetLoader.getAsset("Backgrounds/MainMenu.png", AssetLoader.AssetType.TEXTURE);
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setAlign(Align.center);
        backgroundContents.add(backgroundImage).padTop(PADDING);
        backgroundContents.setFillParent(true);
        backgroundContents.align(Align.top);

        //Foreground stuff
        //Foreground buttons
        mainTable.setDebug(true);
        mainTable.setY(backgroundContents.getY() + backgroundContents.getHeight());

        playButton = new MenuButton("Buttons/Play.atlas");
        aboutButton = new MenuButton("Buttons/About.atlas");
        settingsButton = new MenuButton("Buttons/Settings.atlas");

        mainTable.add(playButton.getActor()).center().top().expandX().row();

        mainTable.add(aboutButton.getActor()).align(Align.bottomRight);
        mainTable.add(settingsButton.getActor()).align(Align.bottomLeft);
        mainTable.setFillParent(true);
        mainTable.align(Align.center);

        //mainTable.getCell(playButton.getActor()).spaceBottom(PADDING);
        //mainTable.getCell(aboutButton.getActor()).spaceBottom(PADDING);


        stage.addActor(backgroundContents);
        stage.addActor(mainTable);
        */
    }

    @Override
    public void assignInputListeners() {

    }

    @Override
    public void disposeUi() {

    }
}
