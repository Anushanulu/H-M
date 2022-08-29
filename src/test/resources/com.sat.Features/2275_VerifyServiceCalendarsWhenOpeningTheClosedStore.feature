#Author: your.email@your.domain.com
#Keywords Summary :
@2275_VerifyServiceCalendarsWhenOpeningTheClosedStore
Feature: TC 2275 : Verify Service Calendars When Opening the closed Store

  @TC_2275_Verify_Service_Calendars_When_Opening_The_Closed_Store
  Scenario Outline: TC 2275 Verify Service Calendars When Opening The Closed Store
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Given User clicks on Calendar link
    Then User selects the store "<StoreName>" and clicks on Next
    And User click on toggle
    When The user enter default visitors "<defaultvisitors>"
    Then User click Yes and able to see Successfully store Opened Message
    And Verify service Calendar is "Enabled"

    Examples: 
      | brand   | country | service      | defaultvisitors | StoreName    | Storestatus |
      | WEEKDAY | Sweden  | Service test |               3 | Hansa, Malmö | Store Close |
