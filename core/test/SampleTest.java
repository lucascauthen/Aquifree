import com.lucascauthen.Managers.Display.ScreenManager;
import com.lucascauthen.Managers.Input.InputManager;
import com.lucascauthen.Modules.Injector;
import com.lucascauthen.Modules.ManagerModule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class SampleTest  {
    ScreenManager screenManagerManager = new ScreenManager();
    @Test
    public void testLevelScreen() {
        screenManagerManager.resume();
        Assert.assertTrue(true);
    }
}
