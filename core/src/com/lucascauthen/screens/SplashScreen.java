package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;



/**
 * Created by Administrator on 4/9/2015.
 */
public class SplashScreen extends GameScreen {
    private GameScreen background;
    private BitmapFont titleFont;
    private Label.LabelStyle titleSkin;
    public SplashScreen(ScreenChangeListener parent, GameScreen background) {
        super(parent);
        this.background = background;
        this.stage = new Stage();
        this.titleSkin = new Label.LabelStyle();
        this.titleFont = new BitmapFont();

        titleSkin.font = titleFont;
        titleText = new Label();
        create();
        ///This is intentional!!! I move the textfield off screen because if you don't, it will draw before the alpha is set and the text fill flash on the screen
        titleText.setPosition(Gdx.graphics.getWidth() * 2 - titleText.getWidth()/2, Gdx.graphics.getHeight()/2 - titleText.getHeight()/2);
        this.stage.addActor(titleText);
    }
    public void create() {
        this.stage.addAction(Actions.sequence(Actions.alpha(0), Actions.run(new Runnable() {
            @Override
            public void run() {
                titleText.setPosition(Gdx.graphics.getWidth() / 2 - titleText.getWidth()/2, Gdx.graphics.getHeight()/2 - titleText.getHeight()/2);
            }
        }), Actions.delay(1), Actions.fadeIn(1), Actions.delay(3), Actions.run(new Runnable() {
            @Override
            public void run() {
                fadeToPreviousScreen(1, false);
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
