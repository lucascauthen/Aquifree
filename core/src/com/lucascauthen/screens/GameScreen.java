package com.lucascauthen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lucascauthen.screens.MenuItems.MenuButton;
import com.lucascauthen.util.AssetLoader;

/**
 * Created by Administrator on 4/7/2015.
 */
public abstract class GameScreen implements Screen {
    protected ScreenChanger parent;
    protected Stage stage;
    private MenuButton backButton;
    protected Table mainTable = new Table();
    protected String backScreen;
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public GameScreen(ScreenChanger parent) {
        this.parent = parent;
        this.stage = new Stage();
    }
    @Override
    public void show() {

    }
    public abstract void update(float delta);
    @Override
    public abstract void render(float delta);

    @Override
    public void resize(int width, int height) {

    }
    public void addBackButton() {
        this.backButton = new MenuButton("Buttons/BackButton.png");
        this.mainTable.add(backButton.getActor());
        float spacing = Gdx.graphics.getWidth() * (1.0f/100.0f);
        this.mainTable.getCell(backButton.getActor()).align(Align.topLeft).spaceTop(spacing).spaceLeft(spacing);
        this.backButton.getActor().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                back(0.25f);
            }
        });
    }
    public void back(float time) {
        if(backScreen != null) //In the back screen is set then go to the desired screen
            parent.changeScreen(backScreen, ScreenChanger.TransitionType.FADE_IN_OUT, time);
        else {//Otherwise exit the app
            AssetLoader test = AssetLoader.getInstance();
            AssetLoader.getInstance().disposeAll();
            Gdx.app.exit();
        }
    }
    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public abstract void hide();

    @Override
    public  abstract void dispose();



}
