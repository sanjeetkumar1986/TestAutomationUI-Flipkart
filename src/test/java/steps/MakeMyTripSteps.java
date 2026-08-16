package steps;

import io.cucumber.java.en.*;
import pages.MakeMyTripPage;

public class MakeMyTripSteps {
    MakeMyTripPage makeMyTripPage=new MakeMyTripPage();
    @Given("the user launches the MakeMyTrip web application")
    public void the_user_launches_the_make_my_trip_web_application() {
        makeMyTripPage.verify_FlightMenu();
    }

    @Given("the user closes any promotional popups or login modals")
    public void the_user_closes_any_promotional_popups_or_login_modals() {
        makeMyTripPage.dismissInitialModal();
    }

    @When("the user chooses the {string} flight option")
    public void the_user_chooses_the_flight_option(String type) {
        makeMyTripPage.selectFlightType(type);

    }

    @When("the user selects {string} as the departure city")
    public void the_user_selects_as_the_departure_city(String source) {
        makeMyTripPage.selectSource(source);
    }

    @When("the user selects {string} as the arrival city")
    public void the_user_selects_as_the_arrival_city(String city) {
      makeMyTripPage.selectDestination(city);
    }

    @When("the user sets the departure date to {string}")
    public void the_user_sets_the_departure_date_to(String date) {
       makeMyTripPage.selectDepartureDate(date);
    }

    @When("the user clicks the flight search button")
    public void the_user_clicks_the_flight_search_button() {
       makeMyTripPage.clickSearchBtn();
    }

    @Then("the user should see the flight search results page")
    public void the_user_should_see_the_flight_search_results_page() {
       makeMyTripPage.verifySearchUrl("flight/search");
    }

    @When("the user sorts the results by {string}")
    public void the_user_sorts_the_results_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the first flight listed should be the lowest price flight")
    public void the_first_flight_listed_should_be_the_lowest_price_flight() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user extracts and records the following flight details:")
    public void the_user_extracts_and_records_the_following_flight_details(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
}
