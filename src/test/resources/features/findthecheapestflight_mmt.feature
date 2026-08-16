# File: search_cheapest_flight.feature

Feature: Search Flights and Retrieve Cheapest Flight Details on MakeMyTrip

  As a traveler looking for budget-friendly options
  I want to search for flights between a source and destination on MakeMyTrip
  So that I can extract and log the details of the cheapest available flight

  @smoke @regression @flight_search
  Scenario Outline: Retrieve details of the lowest fare flight
    Given the user launches the MakeMyTrip web application
    And the user closes any promotional popups or login modals
    When the user chooses the "<trip_type>" flight option
    And the user selects "<source_city>" as the departure city
    And the user selects "<destination_city>" as the arrival city
    And the user sets the departure date to "<travel_date>"
    And the user clicks the flight search button
    Then the user should see the flight search results page
#    When the user sorts the results by "Cheapest"
#    Then the first flight listed should be the lowest price flight
#    And the user extracts and records the following flight details:

    Examples:
      | trip_type | source_city      | destination_city | travel_date     |
      | One Way   | New Delhi, India | Mumbai, India    | Tue Sep 15 2026 |
