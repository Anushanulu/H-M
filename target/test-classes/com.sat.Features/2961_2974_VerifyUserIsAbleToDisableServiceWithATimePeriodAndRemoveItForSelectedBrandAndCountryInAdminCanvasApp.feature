#Author: your.email@your.domain.com
#Keywords Summary :
@2961_2974_Verify_User_Is_Able_To_Disable_Service_With_A_Time_Period_And_Remove_It
Feature: Tc 2961_2974 : Verify user is able to disable Service with a time period and remove it for selected Brand and Country in Admin Canvas App

  @2961_2974_Verify_User_Is_Able_To_Disable_Service_With_A_Time_Period_And_Remove_It
  Scenario Outline:Tc 2961_2974 : Verify user is able to disable Service with a time period and remove it for selected Brand and Country in Admin Canvas App
    Given User Navigate to Booking App
    When User select "<Country>" and "<Brand>"
    Then Navigate to country settings
    When Select brand "<Brand>" and "<Country>"
    And select enabled "<service>"
    Then click on Add Time Period2
    Then input1 "<Start Date>" "<startYear>" "<startmonth>" "<end Date>" "<endYear>" and "<endMonth>"
    And click on apply and ok
    And select enabled "<service>"
    Then click on remove and validate time period is removed
    And click on apply and ok

    Examples: 
      | Country | Brand   | service                 | Start Date | end Date | startYear | startmonth | endYear | endMonth |
      | Sweden  | WEEKDAY | Automation Service Test |         16 |       21 |      2023 | June       |    2023 | July     |
