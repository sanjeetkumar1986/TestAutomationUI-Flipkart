package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BrowserDriver;
import org.junit.jupiter.api.Assertions;

public class CommonPage {
    private static final String flipkart_logo="//img[contains(@src, '31f7e3af490c225f')]";
    protected WebElement getElement(By locator)
    {
        return BrowserDriver.getDriver().findElement(locator);
    }
    public void isFlipkartHomePageDisplayed()
    {
        Assertions.assertTrue(getElement(By.xpath(flipkart_logo)).isDisplayed());
    }

}
