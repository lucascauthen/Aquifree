package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Administrator on 4/7/2015.
 */
public class MainMenuScreen extends GameScreen {
    TextButton playButton;
    TextButton aboutButton;
    TextButton settingsButton;
    TextButton button;
    TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;
    Group background;
    Image backgroundImage;
    Texture backgroundTexture;

    Group foreGround;
    public MainMenuScreen(final ScreenChangeListener parent) {
        super(parent);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        background = new Group();
        background.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        foreGround = new Group();
        foreGround.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage.addActor(background);
        stage.addActor(foreGround);

        backgroundTexture = new Texture("BackGrounds/MainMenu.png");
        backgroundImage = new Image(backgroundTexture);
        //Add background image to background group
        background.addActor(backgroundImage);
        backgroundImage.setPosition(Gdx.graphics.getWidth()/2 - backgroundImage.getWidth()/2, Gdx.graphics.getHeight()/2 - backgroundImage.getHeight()/2);

        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.atlas"));
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("up-button");
        textButtonStyle.down = skin.getDrawable("down-button");
        textButtonStyle.checked = skin.getDrawable("check-button");
        button = new TextButton("Button1", textButtonStyle);
        foreGround.addActor(button);

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fadeToNewScreen(new LevelSelectScreen(parent), 1);
            }
        });


    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
        stage.act(delta);
    }
    public void resume() {
        stage.addAction(Actions.alpha(0));
        stage.addAction(Actions.fadeIn(1));
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void pause() {


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
        font.dispose();
        skin.dispose();
    }
}
