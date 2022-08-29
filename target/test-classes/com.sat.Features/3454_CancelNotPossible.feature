@3454_CancelNotPossible
Feature: TC3454 : Test the Cancel not possible dialog

  Scenario Outline: TC3454_Check that the Cancel not possible dialog
    Given Login to Admin tool App
    When navigate to store settings
    And select brand "<Brand>" and country "<Country>"
    And Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view "Enable" for the service and logout from booking app
    When Login to Resale portal tool with "<url>"
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    And click on Registeryouritems
    And user select or enter below fields "<Store_Name>","<Brand_Name>","<Category>","<Condition>","<Material>","<Unsolditem>"
    And click on registration Submit
    And click on Done
    And check the "Pre-registered" item in available in My items tab
    When user launching ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And searching for existing seller "<existingseller>","<tab>"
    And sign the preregister item
    And click on "<status>" item and generate id by clicking on edit button and save it
    And enter "Men","40","400" and save it
    Then swich to Portal and cancel the item which we have created

    Examples: 
      | Brand   | Country | Store             | Service | url                | username             | password               | Store_Name                   | Brand_Name | Category | Condition  | Material | Unsolditem                 | status  | existingseller            | tab       |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Levi's     | Bags     | Never worn | rubber   | Donate the item to charity | Pending | testerswathi135@gmail.com | All Items |
