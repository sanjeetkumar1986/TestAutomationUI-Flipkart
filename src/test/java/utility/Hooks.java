package utility;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.io.ByteArrayInputStream;

public class Hooks {
    @Before
    public void setup(Scenario scenario)
    {
        // Bind current Cucumber scenario to ThreadLocal
        BasePage.setCurrentScenario(scenario);
        BrowserDriver.getDriver();
        BrowserDriver.navigateToEnvUrl();
    }
    @After
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed()) {
            WebDriver driver = BrowserDriver.getDriver();
            if (driver != null) {
                // Take screenshot as byte array
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // Embed screenshot into Cucumber native report
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");

                // Attach screenshot into Allure Report
               // Allure.addAttachment("Failed Assertion Screenshot", new ByteArrayInputStream(screenshot));
            }
        }
        BrowserDriver.close();
        BasePage.removeCurrentScenario();
    }
}
