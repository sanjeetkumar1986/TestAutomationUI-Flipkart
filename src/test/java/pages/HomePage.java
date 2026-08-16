package pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
        private static final By SEARCH_INPUT = By.xpath("//input[@name='q' and not(@readonly)]");
        private static final By SEARCH_BUTTON = By.xpath("//form[contains(@class,'lilxh_ header-form-search')]//button[@type='submit']");
        private static final By SEARCH_HEAD_TITLE = By.xpath("//div[@class='Vba09Z']//span[contains(text(),'Showing')]");
        private static final By SEARCH_ITEMS_HEADER = By.xpath("//div[@class='RG5Slk']");
        private static final By CLOSE_LOGIN_POPUP= By.xpath("//*[@class='b3wTlE' and @role='button']");
        public void setSearch_Input(String productName)
        {
                sendKeys(SEARCH_INPUT,productName);
        }
        public void closeLoginAllert()
        {
                click(CLOSE_LOGIN_POPUP);
        }
        public void click_Search()
        {
                click(SEARCH_BUTTON);
        }
        public void verify_Search_Header(String textHead)
        {
                Assertions.assertTrue(get_element_text(SEARCH_HEAD_TITLE).contains(textHead));
        }
        public void verifyPageTitle(String pageTitle)
        {
                Assertions.assertTrue(getTitle().contains(pageTitle));
        }

}

