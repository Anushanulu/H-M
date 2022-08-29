#Author: your.email@your.domain.com
#Keywords Summary :
@2949_Verify_user_is_able_to_disable_Service_with_a_time_period_for_selected_Brand_in_Admin_Canvas_App
Feature: TC 2949 :Verify user is able to disable Service with a time period for selected Brand in Admin Canvas App

  @2949_Verify_user_is_able_to_disable_Service_with_a_time_period_for_selected_Brand_in_Admin_Canvas_App
  Scenario Outline:TC 2949 : Verify user is able to disable Service with a time period for selected Brand in Admin Canvas App
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    Then Navigate to brand settings
    And Select brand "<brand>"
    And select enabled "<service>"
    Then click on Add Time Period
    Then input "<Start Date>" "<startYear>" "<startmonth>" "<end Date>" "<endYear>" and "<endMonth>"
    And click on apply and ok
    And select enabled "<service>"
    Then click on remove and validate time period is removed
    And click on apply and ok

    Examples: 
      | country | brand   | service                 | Start Date | end Date | startYear | startmonth | endYear | endMonth |
      | Sweden  | WEEKDAY | Automation Service Test |          3 |       10 |      2022 | October    |    2023 | October  |
