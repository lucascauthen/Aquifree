package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;


/**
 * Created by Administrator on 4/9/2015.
 */
public class SplashScreen extends GameScreen {
    private GameScreen background;
    private TextField titleText;
    private BitmapFont titleFont;
    private TextField.TextFieldStyle titleTextFieldStyle;
    public SplashScreen(ScreenChangeListener parent, GameScreen background) {
        super(parent);
        this.background = background;
        this.stage = new Stage();
        this.titleTextFieldStyle = new TextField.TextFieldStyle();
        this.titleFont = new BitmapFont();
        this.titleFont.scale(5);
        this.titleTextFieldStyle.font = titleFont;
        titleText = new TextField("Aguifree", titleTextFieldStyle);
        titleText.setPosition(Gdx.graphics.getWidth()/2 - titleText.getWidth()/2, Gdx.graphics.getHeight()/2 - titleText.getHeight()/2);
        this.stage.addActor(titleText);
    }
    public void create() {
        this.stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1), Actions.run(new Runnable() {
            @Override
            public void run() {
                fadeToPreviousScreen(1);
            }
        })));
    }
    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        background.render(delta);
        this.stage.draw();
        this.stage.act(delta);
    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
