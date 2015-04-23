package com.lucascauthen.screens.Transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.lucascauthen.screens.ScreenChanger;

/**
 * Created by Administrator on 4/14/2015.
 */
public class FadeOutTransition extends Transition {
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        before.draw();
        after.draw();
        before.act();
        after.act();
    }

    public FadeOutTransition(Stage before, Stage after, ScreenChanger parent, float duration) {
        super(before, after, parent, duration);
        primaryTask();
    }
    //This is called to fade out the before screen
    public void primaryTask() {
        //after.addAction(Actions.alpha(1));
        before.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeOut(this.duration/2), Actions.run(new Runnable() {
            @Override
            public void run() {
                secondaryTask();
            }
        })));
    }
    //This is called when the primary task is finished. This fades in the after stage
    public void secondaryTask() {
        after.addAction(Actions.sequence(Actions.fadeIn(this.duration/2), Actions.run(new Runnable() {
            @Override
            public void run() {
                isFinished = true;
                parent.finishedTransition();
            }
        })));
    }
}
