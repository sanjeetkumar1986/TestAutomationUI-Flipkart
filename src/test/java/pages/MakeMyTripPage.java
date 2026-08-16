package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class MakeMyTripPage extends BasePage{
    private static final By FLIGHTMENU=By.xpath( "//li[@data-cy='menu_Flights']//a");
    private static final By FROMINPUT=By.xpath("//input[@data-cy='fromCity' and @readonly]");
    private static final By FROMINPUTEDIT=By.xpath("//input[@placeholder='From']");
    private static final By SOURCELIST=By.xpath("//div[@role='listbox']");
    private static final By oneWay = By.cssSelector("li[data-cy='oneWayTrip']");
    private static final By roundTrip = By.cssSelector("li[data-cy='roundTrip']");
    private static final By multiCity = By.cssSelector("li[data-cy='mulitiCityTrip']");
    private static final By TOINPUT=By.xpath("//input[@data-cy='toCity' and @readonly]");
    private static final By TOINPUTEDIT=By.xpath("//input[@placeholder='To']");
    private static final String DEPARTUREDAY="//div[@aria-label='%s']";
    private static final By SEARCHlINK=By.xpath("//a[text()='Search']");
    private static final String PLACEOPTION="//div[@class='revampedSuggestionContent']//span[text()='%s']";
    public void verify_FlightMenu()  {
       try {
           Thread.sleep(10000);
           Assertions.assertTrue(getLocator(FLIGHTMENU).isDisplayed());
       }catch (Exception e)
       {
           System.out.println(e.getMessage());
       }

    }
    public void selectFlightType(String flightType)
    {
        if(flightType.equalsIgnoreCase("One Way"))
        {
            click(oneWay);
        }else if(flightType.equalsIgnoreCase("Round Trip"))
        {
            click(roundTrip);
        }
        else
        {
            click(multiCity);
        }
    }
    public void selectSource(String place)
    {
        click(FROMINPUT);
        sendKeys(FROMINPUTEDIT,place);
       // getLocator(SOURCELIST).findElements(By.xpath("revampedSection")).get(1).click();
        String locator=String.format(PLACEOPTION,place);
        click(By.xpath(locator));
    }
    public void selectDestination(String place)
    {
        click(TOINPUT);
        sendKeys(TOINPUTEDIT,place);
        String locator=String.format(PLACEOPTION,place);
        click(By.xpath(locator));
       // getLocator(SOURCELIST).findElements(By.xpath("revampedSuggestionContent")).get(0).click();
    }
    public void selectDepartureDate(String day)
    {
       String departure= String.format(DEPARTUREDAY,day);
       click(By.xpath(departure));
    }
    public void clickSearchBtn()
    {
        click(SEARCHlINK);
    }
    public void verifySearchUrl(String search)
    {
        try {
            Assertions.assertTrue(driver.getCurrentUrl().contains(search));
            Thread.sleep(30000);
        }catch (Exception e)
        {
            log.info(e.getMessage());
        }

    }
}
