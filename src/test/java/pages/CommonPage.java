package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BrowserDriver;
import org.junit.jupiter.api.Assertions;

public class CommonPage {
    private static final String flipkart_logo="//img[contains(@src, '31f7e3af490c225f')]";
    private static String admission_enq_button="//span[text()='Enquire Now']/parent::a[contains(@id,'myBtn2')]";
    private static String admission_button="//span[contains(text(),'Admissions')]/parent::a[contains(@id,'myBtn2')]";

    protected WebElement getElement(By locator)
    {
        return BrowserDriver.getDriver().findElement(locator);
    }
    public void isFlipkartHomePageDisplayed()
    {
        Assertions.assertTrue(getElement(By.xpath(flipkart_logo)).isDisplayed());
    }
    public void isUinversityHomePageOpen()
    {

        Assertions.assertTrue( getElement(By.xpath(admission_button)).isDisplayed());
        getElement(By.xpath(admission_enq_button)).click();
    }

}
