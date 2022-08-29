#Author: your.email@your.domain.com
#Keywords Summary :
@2990_2994_Verify_user_is_able_to_add_a_new_Service_and_view_service_to_Store
Feature: Verify_user_is_able_to_add_a_new_Service_and_view_service_to_Store_for_selected_Brand_and_Country_in_Admin_Canvas_App

  @2990_2994_Verify_user_is_able_to_add_a_new_Service_and_view_service_to_Store
  Scenario Outline: Verify_user_is_able_to_add_a_new_Service_and_view_service_to_Store_for_selected_Brand_and_Country_in_Admin_Canvas_App
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    Then Navigate to store settings
    Then select the Store "<Store>"
    Then click on Add service
    Then check status "Enable"
    Then select "<service>" from the dropdown
    Then click on Add button and Ok button
    And Validate success message

    Examples: 
      | brand   | country | service         | defaultvisitors | Store |
      | WEEKDAY | Sweden  | AutomationSale5 |               3 | Hansa |
