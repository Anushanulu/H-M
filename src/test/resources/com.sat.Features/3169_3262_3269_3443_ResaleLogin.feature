@3169_3262_3269_3443_RegisteringCancellingItem
Feature: TC-3169,3262,3169,3443 : Testing Login Functionality

  Scenario Outline: TC3169_3262_3269_3443_Verify user can login and register an item in Resale portal and cancel the resgistered item
    Given Login to Admin tool App
    When navigate to store settings
    And select brand "<Brand>" and country "<Country>"
    And Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view "Enable" for the service and logout from booking app
    When User navigates to ResalePortal "<url>" login page
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    And veify success msg with username "Tester swathi"
    And click on Registeryouritems
    And user select or enter below fields "<Store_Name>","<Brandname>","<Category>","<Condition>","<Material>","<Unsolditem>"
    And click on registration Submit
    And user can view Thankyou Msg
    And click on Done and success msg with username "Tester swathi"
    Then confirmation email should sent with "Confirmation email | Weekday 2nd-hand Curated"
    And check currently created "<status>" item is there in MyItems tab
    And cancel item which is register and check the cancellation email "Canceled Item(s) |  Curated Secondhand"

    Examples: 
      | Brand   | Country | Store             | Service | url                | username             | password               | Store_Name                   | Brandname | Category | Condition | Material | Unsolditem              | status         |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Pre-registered |
