package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.DragScrollListener;
import com.lucascauthen.screens.MenuItems.MenuText;

/**
 * Created by Administrator on 4/7/2015.
 */
public class AboutMenuScreen extends GameScreen {
    MenuText text;
    ScrollPane scrollPane;
    Table scrollTable;
    @Override
    public void resume() {

    }


    public AboutMenuScreen(ScreenChanger setParent) {
        super(setParent);
        stage = new Stage();
        scrollTable = new Table();
        String about = "The purpose of this project is to raise money for people who need water. Water is the most important resource in everyone's life. " +
                "It is a sad fact that not everyone has access to clean water. By playing this game, 90 percent of the ad revenue goes toward clean water projects. " +
                "The remaining 10 percent will go toward paying for the costs of running this app, and hopefully there will be a little left over to go to my college fund. " +
                "Thank you for playing";
        text = new MenuText(about, Color.BLACK, 70);
        text.getActor().setWrap(true);
        mainTable.add(text.getActor()).width(Gdx.app.getGraphics().getWidth() * (2.0f / 3.0f));
        scrollPane = new ScrollPane(mainTable);
        scrollTable.add(scrollPane).fill().expand();
        scrollTable.setFillParent(true);
        stage.addActor(scrollTable);
        this.backScreen = "MainMenu";
        //this.addBackButton();
        stage.addListener(new DragScrollListener(scrollPane) {
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

    @Override
    public void update(float delta) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
