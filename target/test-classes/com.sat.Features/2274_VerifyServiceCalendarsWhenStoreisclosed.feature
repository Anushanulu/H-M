#Author: your.email@your.domain.com
#Keywords Summary :
@2274_VerifyServiceCalendarsWhenStoreisclosed
Feature: Tc 2274 : Verify Service Calendars When Store is closed

  @TC_2274_Verify_Service_Calendars_When_Store_is_closed
  Scenario Outline: TC 2274 Verify Service Calendars When Store is closed
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Given User clicks on Calendar link
    Then User selects the store "<StoreName>" and clicks on Next
    And User click on toggle
    Then Select Apply Button and verify success message
    And Verify service Calendar is "Disabled"

    Examples: 
      | brand   | country | service      | defaultvisitors | StoreName    | Storestatus |
      | WEEKDAY | Sweden  | Service test |               3 | Hansa, Malmö | Store Open  |
