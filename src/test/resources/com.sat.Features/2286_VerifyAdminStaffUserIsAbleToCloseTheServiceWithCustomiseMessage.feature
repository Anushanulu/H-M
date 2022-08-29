#Author: swetha.pr@hcl.com
#Keywords Summary :
@2286_Verify_Admin_Staff_user_is_able_to_close_the_Service_with_Customise_message
Feature: TC 2286 :Verify Admin Staff user is able to close the Service with Customise message

  @2286_Verify_Admin_Staff_user_is_able_to_close_the_Service_with_Customise_message
  Scenario Outline:TC 2286 : Verify Admin Staff user is able to close the Service with Customise message
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then check all the services are "Enable selected" for "<StoreName>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Then Select the service "<service>"
    And Enter the Customise message "Throught Automation store is disabled"
    And check the service status and "Disable" "<defaultvisitors>"
     ######### enabling the service which is disabled ##################
    Then Select the service "<service>"
    And check the service status and "Enable" "<defaultvisitors>"

    Examples: 
      | brand   | country | service | defaultvisitors | StoreName | Storestatus |
      | WEEKDAY | Sweden  | Resell  |               3 | Hansa     | Store Open  |
