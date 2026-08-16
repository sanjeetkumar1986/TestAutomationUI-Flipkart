package pages;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.BrowserDriver;

import java.time.Duration;

public class BasePage {
    private static final ThreadLocal<Scenario> currentScenario=new ThreadLocal<>();
    protected WebDriver driver;
    protected WebDriverWait wait;
    Logger log = LoggerFactory.getLogger(BasePage.class);
    public BasePage()
    {
        this.driver= BrowserDriver.getDriver();
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void setCurrentScenario(Scenario scenario)
    {
            currentScenario.set(scenario);
    }
    public static void removeCurrentScenario()
    {
        currentScenario.remove();
    }
    // Helper method to attach screenshot on step failure
    private void captureScreenshotOnFailure(String actionDetails) {
        Scenario scenario = currentScenario.get();
        WebDriver activeDriver = BrowserDriver.getDriver();

        if (scenario != null && activeDriver != null) {
            try {
                byte[] screenshot = ((TakesScreenshot) activeDriver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure during: " + actionDetails);
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot in BasePage: " + e.getMessage());
            }
        }
    }

    // Wrapped action for Dropdown Selection
    public void selectByVisibleText(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            captureScreenshotOnFailure("Select option '" + text + "' from " + locator);
            throw e; // Re-throw to ensure step fails in Cucumber
        }
    }

    // Wrapped action for Element Click
    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            captureScreenshotOnFailure("Click element: " + locator);
            throw e;
        }
    }

    // Wrapped action for Input Field Typing
    public void sendKeys(By locator, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            captureScreenshotOnFailure("Type '" + value + "' into " + locator);
            throw e;
        }
    }
    public String getTitle()
    {
      return driver.getTitle();
    }
    public String get_element_text(By locator) {
        String value;
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            value = element.getText();
        }catch (Exception e)
        {
            captureScreenshotOnFailure("Click element: " + locator);
            throw e;
        }
        return value;
    }
    public void dismissInitialModal()
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(60));
        try {
            By closeBtnLocator = By.xpath("//span[contains(@class,'commonModal__close') or @data-cy='closeModal']");

            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeBtnLocator));
            closeButton.click();
        }catch (Exception e)
        {
                log.info("Popup did not appear or was already dismissed.");
        }
    }
    public WebElement getLocator(By locator)
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
}
