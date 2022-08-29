#Author: Swetha.pr@hcl.com
#Keywords Summary :
@2951_Verify_user_is_able_to_enable_multiple_Services_for_selected_Brand_in_Admin_Canvas_App
Feature:TC 2951 : Verify user is able to enable multiple Services for selected Brand in Admin Canvas App

  #2951_Verify_user_is_able_to_enable_multiple_Services_for_selected_Brand_in_Admin_Canvas_App
  @2951_Verify_user_is_able_to_enable_multiple_Services_for_selected_Brand_in_Admin_Canvas_App
  Scenario Outline: TC 2951 : Verify user is able to enable multiple Services for selected Brand in Admin Canvas App
    Given Login to Canvas App with Admin credentials1
    Then Select1 Country "<Country>" and Brand "<Brand>"
    Then Navigate to brand settings
    And Select brand "<Brand>"
    Then select "<ServiceName1>" to disable1
    When Select "<ServiceName2>" to disable2
    And "Disable selected" services should be available
    When Select disabled1 service "<ServiceName1>"
    When Select disabled2 service "<ServiceName2>"
    Then click on1 "Enable selected"

    Examples: 
      | ServiceName1     | ServiceName2            | Country | Brand   |
      | April month Sale | Automation Service Test | Sweden  | WEEKDAY |
