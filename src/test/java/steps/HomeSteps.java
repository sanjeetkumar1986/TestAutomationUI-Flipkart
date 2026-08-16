package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.HomePage;

public class HomeSteps {
    CommonPage commonPage=new CommonPage();
    HomePage homePage= new HomePage();
    @Given("the user opens the browser")
    public void the_user_opens_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        commonPage.isFlipkartHomePageDisplayed();
        //System.out.println("Sanjeet");

    }
    @Given("navigates to the Flipkart homepage")
    public void navigates_to_the_flipkart_homepage() {
       // System.out.println("Sanjeet");
    }
    @Given("closes any login popup if displayed")
    public void closes_any_login_popup_if_displayed() {
        homePage.closeLoginAllert();
    }
    @When("the user enters {string} into the search bar")
    public void the_user_enters_into_the_search_bar(String inputItem) {
        homePage.setSearch_Input(inputItem);
       // System.out.println("Sanjeet");
    }
    @When("clicks on the search button")
    public void clicks_on_the_search_button() {
        homePage.click_Search();
    }
    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String pageTitle) {
       homePage.verifyPageTitle(pageTitle);
    }
    @Then("the search results header should display {string}")
    public void the_search_results_header_should_display(String productHeader) {
        homePage.verify_Search_Header(productHeader);
    }
    @Then("all listed items on the first page should contain {string} in their titles")
    public void all_listed_items_on_the_first_page_should_contain_in_their_titles(String string) {
        System.out.println("Sanjeet");
    }

}
