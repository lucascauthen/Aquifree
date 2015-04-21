package com.lucascauthen.screens.Transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lucascauthen.screens.ScreenChanger;

/**
 * Created by Administrator on 4/21/2015.
 */
public class EmptyTransition extends Transition {

    public EmptyTransition(Stage before, Stage after, ScreenChanger parent, float duration) {
        super(before, after, parent, duration);
        this.isFinished = true;
    }

    @Override
    public void render(float delta) {
        Gdx.app.log("EmptyTransition", "Trying to render an empty transition.");
    }
}
