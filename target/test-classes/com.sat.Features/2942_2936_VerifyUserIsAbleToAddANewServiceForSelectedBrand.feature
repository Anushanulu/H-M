#Author: your.email@your.domain.com
#Keywords Summary :
@TC_2942_2936_2958_2966_2990_2994_Verify_User_Is_Able_To_Add_A_New_Service_And_View_Added_Services_For_Selected_Brand_country_and_store
Feature: TC 2942_2942_2936_2958_2966_2990_2994 : Verify user is able to add a new Service And View Added Services for selected Brand in Admin Canvas App

  @TC_2942_2936_Verify_User_Is_Able_To_Add_A_New_Service_And_View_Added_Services
  Scenario Outline: TC TC 2942_2942_2936_2958_2966_2990_2994 : Verify user is able to add a new Service And View Added Serices for selected Brand in Admin Canvas App
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    Then Navigate to brand settings
    Then Click on Add service
    Then Enable status toggle button should be "Enable"
    And Specify display name "<Display Name>" and "<API name>"
    Then Click on Add and Ok
    And Verify the service "<Display Name>" in the list
    # add service at country level
    Then Click on Settings
    When Navigate to Country settings
    Then click on Add service
    Then check status "Enable"
    Then select "<Display Name>" from the dropdown
    Then Enter default allowed Visitors "10" click on Add button and Ok button
    And Verify the success message
    #add service at store level
    Then Navigate to store settings
    Then select the Store "<Store>"
    Then click on Add service
    Then check status "Enable"
    Then select "<Display Name>" from the dropdown
    Then click on Add button and Ok button
    And Validate success message

    Examples: 
      | country | brand   | Display Name | API name    | defaultvisitors | Store |
      | Sweden  | WEEKDAY | Automation5  | Automation5 |               3 | Hansa |