package com.lucascauthen.screens.Transitions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;
import com.lucascauthen.screens.GameScreen;
import com.lucascauthen.screens.ScreenChangeListener;
import com.lucascauthen.screens.ScreenManager;

/**
 * Created by Administrator on 4/14/2015.
 */
public class FadeOutInTransition extends Transition {
    Stage currentStage;
    public FadeOutInTransition(final Stage beforeStage, final Stage afterStage, final float time, ScreenChangeListener manager) {
        super(beforeStage, afterStage, manager);
        Gdx.app.log("FadeInOut", "Starting transition.");
         //Main stage runs main actions
        this.setCurrentStage(before);
        Gdx.app.log("FadeInOut", "Setting after screen alpha to max");
        after.addAction(Actions.alpha(1)); //Make after stage Completely invisible
        Gdx.app.log("FadeInOut", "Setting before screen alpha to min");
        before.addAction(Actions.alpha(0)); //Make before stage Completely visible
        Gdx.app.log("FadeInOut", "Fading out before screen");
        before.addAction(Actions.sequence(Actions.fadeOut(time), Actions.run(new Runnable() { //Fade out the before screen then add action to after screen
            @Override
            public void run() {
                Gdx.app.log("FadeInOut", "Fading in after screen");
                setCurrentStage(after);
                after.addAction(Actions.sequence(Actions.fadeIn(time), Actions.run(new Runnable() { //Fade in after screen
                    @Override
                    public void run() {
                        Gdx.app.log("FadeInOut", "Disposing of before stage");
                        before.dispose();
                        Gdx.app.log("FadeInOut", "End transition");
                        afterStage.addAction(Actions.alpha(1));
                        parent.previousScreen(ScreenManager.TransitionType.NONE, 0); //Revert to the logic of the after screen
                    }
                })));
            }
        })));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255.0f, 255/255.0f, 255/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        currentStage.draw();
        currentStage.act(delta);
    }
    public void setCurrentStage(Stage stage) {
        this.currentStage = stage;
    }
}
