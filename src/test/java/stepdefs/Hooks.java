package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BaseClass;

public class Hooks extends BaseClass {


    @Before
    public void initializeAppium() throws Exception {
        startAppiumService();
        beforeClass();
    }

    @After(order = 1)
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot shot = (TakesScreenshot) BaseClass.driver;
            byte[] screenshot = shot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After(order = 0)
    public void quit() {
        tearDown();
    }

}
