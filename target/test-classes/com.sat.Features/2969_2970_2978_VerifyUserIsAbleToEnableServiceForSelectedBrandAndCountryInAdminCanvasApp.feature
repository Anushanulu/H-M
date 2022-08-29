#Author:Swetha.pr@hcl.com
#Keywords Summary :
@2969_2970_2978_Verify_User_Is_Able_To_Enable_And_Disable_Single_and_multiple_Service
Feature:TC 2969_2970_2978 : Verify User Is Able To Enable And Disable Multiple Service For Selected Brand And Country In Admin Canvas App

  @2969_2970_2978_Verify_User_Is_Able_To_Enable_And_Disable_multiple_Service
  Scenario Outline:TC 2969_2970_2978 : Verify User Is Able To Enable And Disable Multiple Service For Selected Brand And Country In Admin Canvas App
    Given User Navigate to Booking App
    #Then Select2 Country "<Country>" and Brand "<Brand>"
    Then Navigate to country settings
    And Select2 brand "<Brand>" and "<Country>"
    Then select1 "<ServiceName1>" to disable
    When Select2 "<ServiceName2>" to disable
    And "Disable selected" services should be available
    When Select1 disabled service "<ServiceName1>"
    When Select2 disabled service "<ServiceName2>"
    Then click on2 "Enable selected"

    Examples: 
      | ServiceName1     | ServiceName2            | Country | Brand   |
      | April month Sale | Automation Service Test | Sweden  | WEEKDAY |

  @2969_Verify_User_Is_Able_To_Enable_And_Disable_multiple_Service
  Scenario Outline: Verify User Is Able To Enable And Disable single Service For Selected Brand And Country In Admin Canvas App
    Given User Navigate to Booking App
    #Then Select2 Country "<Country>" and Brand "<Brand>"
    Then Navigate to country settings
    And Select2 brand "<Brand>" and "<Country>"
    Then select1 "<ServiceName2>" to disable
    And "Disable selected" services should be available
    When Select1 disabled service "<ServiceName2>"
    Then click on2 "Enable selected"

    Examples: 
      | ServiceName2            | Country | Brand   |
      | Automation Service Test | Sweden  | WEEKDAY |
