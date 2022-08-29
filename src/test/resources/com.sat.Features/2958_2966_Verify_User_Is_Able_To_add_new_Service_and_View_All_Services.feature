#Author: your.email@your.domain.com
#Keywords Summary :
@2958_2966_Verify_User_Is_Able_To_add_new_Service_and_View_All_Services
Feature: Verify User Is Able To Add new service and View All Services For Selected Brand And Country In Admin Canvas App

  @2958_2966_Verify_User_Is_Able_To_add_new_Service_and_View_All_Services
	Scenario Outline: Verify User Is Able To Add new service and View All Services For Selected Brand And Country In Admin Canvas App
	  Given User Navigate to Booking App
    When Navigate to Country settings
    Then User select country "<country>" and brand "<brand>"
    Then click on Add service
    Then check status "Enable"
    Then select "<service>" from the dropdown
    Then Enter default allowed Visitors "5" click on Add button and Ok button
    And Verify the success message

    Examples: 
      | country | brand   | service         |
      | Sweden  | WEEKDAY | AutomationSale5 |
