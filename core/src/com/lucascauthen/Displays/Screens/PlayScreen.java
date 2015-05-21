package com.lucascauthen.Displays.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.lucascauthen.Game.Map;
import com.lucascauthen.Managers.Display.ScreenChanger;

/**
 * Created by Administrator on 4/24/2015.
 */
public class PlayScreen extends GameScreen {
    private OrthographicCamera camera = new OrthographicCamera();
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private Map map;
    public PlayScreen(ScreenChanger parent) {
    super(parent);
    this.map = new Map();
}

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        map.act(delta);
        map.render();
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
}
