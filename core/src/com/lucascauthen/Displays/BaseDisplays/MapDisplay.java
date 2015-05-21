package com.lucascauthen.Displays.BaseDisplays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.lucascauthen.Game.Map;

/**
 * Created by Administrator on 5/20/2015.
 */
public class MapDisplay implements Screen {
    private OrthographicCamera camera = new OrthographicCamera();
    private TiledMapRenderer tiledMap;
    private Map map;
    private boolean isVisible = true;
    private boolean isPaused = false;
    private boolean isLoaded = false;
    public MapDisplay() {}
    public MapDisplay(String mapName) {
        loadMap(mapName);
        isLoaded = true;
    }
    public void loadMap(String mapName) {
        //Functionality for loading maps
        assert false; //Temporary
    }
    @Override
    public void show() {
        isVisible = true;
    }

    @Override
    public void render(float delta) {
        if(isLoaded && map != null) {
            while (!isPaused) {
                map.act(delta);
            }
            while (isVisible) {
                map.render();
            }
        } else {
            Gdx.app.log("MapDisplay", "Trying to render or update a map that does not exist.");
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {
        isPaused = true;
    }

    @Override
    public void resume() {
        isPaused = false;
    }

    @Override
    public void hide() {
        isVisible = false;
    }

    @Override
    public void dispose() {
        map.dispose();
        isLoaded = false;
    }
}
