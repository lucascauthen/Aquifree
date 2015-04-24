package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.lucascauthen.screens.MenuItems.MenuText;
import com.lucascauthen.util.AssetLoader;


/**
 * Created by Administrator on 4/9/2015.
 */
public class SplashScreen extends GameScreen {
    MenuText text;
    Table container;
    public SplashScreen(ScreenChanger setParent) {
        super(setParent);
        this.stage = new Stage();
        container = new Table();
        text = new MenuText("Auifree", "Fonts/MenuFont70.fnt", Color.BLACK);

        container.add(text.getActor());
        container.align(Align.center);
        container.setFillParent(true);
        stage.addActor(container);
        stage.addAction(Actions.sequence(Actions.delay(2.0f), Actions.run(new Runnable() {
            @Override
            public void run() {
                parent.changeScreen("MainMenu", ScreenChanger.TransitionType.FADE_IN_OUT, 1f);
            }
        })));
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.draw();
        this.stage.act(delta);
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
        stage.dispose();
    }
}
