@2488_DeclineItem
Feature: TC2488: Verify that user is able to see the email when item is declined

  Scenario Outline: TC2488_Test user is able to see the email when item is declined
    Given Login to Admin tool App
    When navigate to store settings
    And select brand "<Brand>" and country "<Country>"
    And Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view "Enable" for the service and logout from booking app
    When User login to ResalePortal "<url>" with valid "<username>" and "<password>"
    When register an item with below fields "<Store_Name>","<Brand>","<Category>","<Condition>","<Material>","<Unsolditem>" and submit it
    And user can login to ResaleApp and search for "<existingseller>","<tab>" and open the item "<status>" decline it
    And run the automatic cloudflow job for declineitem "SendEmail_Seller_DeclineItem"
    Then decline email should sent with "Declined Item(s) | Weekday 2nd-hand Curated"

    Examples: 
      | Brand   | Country | Store             | Service | url                | username             | password               | Store_Name                   | Brand | Category | Condition | Material | Unsolditem              | existingseller            | tab          | status         |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Biba  | Dresses  | Vintage   | Cotton   | Pick-up item from store | testerswathi135@gmail.com | Pre-Register | Pre registered |
