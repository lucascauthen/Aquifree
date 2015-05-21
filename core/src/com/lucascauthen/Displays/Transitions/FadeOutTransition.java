package com.lucascauthen.Displays.Transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.lucascauthen.Managers.Display.ScreenChanger;

/**
 * Created by Administrator on 4/14/2015.
 */
public class FadeOutTransition extends Transition {
    Stage active;
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        active.draw();
        active.act(Gdx.graphics.getDeltaTime());
    }

    public FadeOutTransition(Stage before, Stage after, ScreenChanger parent, float duration) {
        super(before, after, parent, duration);
        after.addAction(Actions.alpha(0));
        after.act();
        active = before;
        fadeOutTask();
    }
    //This is called to fade out the before screen
    public void fadeOutTask() {
        active.addAction(Actions.sequence(Actions.alpha(0, duration), Actions.run(new Runnable() {
            @Override
            public void run() {
                active = after;
                fadeInTask();
            }
        })));
    }
    //This is called when the primary task is finished. This fades in the after stage
    public void fadeInTask() {
        active.addAction(Actions.sequence(Actions.alpha(1, duration), Actions.run(new Runnable() {
            @Override
            public void run() {
                isFinished = true;
                parent.finishedTransition();
            }
        })));
    }
}
