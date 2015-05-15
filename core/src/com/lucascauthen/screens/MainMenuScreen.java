package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lucascauthen.screens.MenuItems.MenuButton;
import com.lucascauthen.screens.MenuItems.TextMenuButton;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public class MainMenuScreen extends GameScreen {
    private final float PADDING = 15f;
    MenuButton playButton;
    MenuButton aboutButton;
    MenuButton settingsButton;


    Image backgroundImage;
    Texture backgroundTexture;
    Table backgroundContents;

    public MainMenuScreen(final ScreenChanger parent) {
        super(parent);
        Gdx.input.setInputProcessor(stage);

        //Background stuff
        backgroundContents = new Table();
        backgroundContents.setDebug(true);
        backgroundTexture = (Texture)AssetLoader.getInstance().getAsset("Backgrounds/MainMenu.png", AssetLoader.AssetType.TEXTURE);
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


        //Listeners
        playButton.getActor().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.changeScreen("LevelSelect", ScreenChanger.TransitionType.FADE_IN_OUT, 0.25f);
            }
        });
        aboutButton.getActor().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.changeScreen("About", ScreenChanger.TransitionType.FADE_IN_OUT, 0.25f);
            }
        });
        settingsButton.getActor().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.changeScreen("Settings", ScreenChanger.TransitionType.FADE_IN_OUT, 0.25f);
            }
        });
        //Fade in action

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
    }
    @Override
    public void pause() {


    }

    @Override
    public void resume() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
