#Author: swetha.pr@hcl.com
#Keywords Summary :
@2282_Verify_Admin_Staff_user_is_able_to_close_the_Service
Feature: TC 2282 :Verify Admin Staff user is able to close the Service

  @2282_Verify_Admin_Staff_user_is_able_to_close_the_Service
  Scenario Outline:TC 2282: Verify Admin Staff user is able to close the Service
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then check all the services are "Enable selected" for "<StoreName>"
    Then User Check "<Storestatus>" for "<StoreName>"
    #Given User clicks on Calendar link
    #Then User selects the store "<StoreName>" and clicks on Next
    Then Select the service "<service>"
    And check the service status and "Disable" "<defaultvisitors>"
    ######### enabling the service which is disabled ##################
    Then Select the service "<service>"
    And check the service status and "Enable" "<defaultvisitors>"

    Examples: 
      | brand   | country | service | defaultvisitors | StoreName | Storestatus |
      | WEEKDAY | Sweden  | Resell  |               3 | Hansa     | Store Open  |
