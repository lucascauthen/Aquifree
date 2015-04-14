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
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lucascauthen.screens.MenuItems.MenuButton;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public class MainMenuScreen extends GameScreen {
    MenuButton playButton;
    MenuButton aboutButton;
    MenuButton settingsButton;
    TextButtonStyle textButtonStyle;
    BitmapFont buttonFont;
    Skin skin;
    TextureAtlas buttonAtlas;
    Group background;
    Image backgroundImage;
    Texture backgroundTexture;
    Table menuContents;

    Group foreGround;
    public MainMenuScreen(final ScreenChangeListener parent) {
        super(parent);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        //Background stuff
        background = new Group();
        background.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        backgroundTexture = (Texture)AssetLoader.getInstance().getAsset("Backgrounds/MainMenu.png", AssetLoader.AssetType.TEXTURE);
        backgroundImage = new Image(backgroundTexture);
        background.addActor(backgroundImage);

        //Foreground stuff
        foreGround = new Group();
        foreGround.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Foreground button style/font


        //Foreground buttons
        playButton = new MenuButton("Play");
        aboutButton = new MenuButton("About");
        settingsButton = new MenuButton("Settings");
        menuContents = new Table();

        menuContents.add(playButton.get()).expandX().center().row();
        menuContents.row();
        menuContents.add(aboutButton.get()).expandX().center().row();
        menuContents.row();
        menuContents.add(settingsButton.get()).expandX().center().row();
        menuContents.setFillParent(true);
        //foreGround.addActor(menuContents);
        stage.addActor(background);
        stage.addActor(foreGround);



        //Button stuff to change later

        //These have to start as invisible because otherwise they will flash on the screen before their alpha is set
        background.setVisible(false);
        foreGround.setVisible(false);

        //Listeners
        stage.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                fadeToNewScreen(new LevelSelectScreen(parent), 1);
            }
        });

        //Fade in action
        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.delay(2), Actions.run(new Runnable() {
            @Override
            public void run() {
                backgroundImage.setPosition(Gdx.graphics.getWidth()/2 - backgroundImage.getWidth()/2, Gdx.graphics.getHeight()/2 - backgroundImage.getHeight()/2);
                background.setVisible(true);
                foreGround.setVisible(true);
                Gdx.input.setInputProcessor(stage);
            }
        }), Actions.fadeIn(1)));

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
    public void resume() {
        stage.addAction(Actions.alpha(0));
        stage.addAction(Actions.fadeIn(1));
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void resumeWithoutFade() {
        stage.addAction(Actions.alpha(1));
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
    }
}
