@3273_BookingSlot
Feature: TC3273 : Check user is able to book a slot in Resale portal

  Scenario Outline: TC3273_Verify taht user is able to book a slot in Resale portal
    Given Login to Admin tool App
    When navigate to store settings
    And select brand "<Brand>" and country "<Country>"
    And Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view "Enable" for the service and logout from booking app
    When User navigates to ResalePortal "<url>" login page
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    And click on Registeryouritems
    And user select or enter below fields "<Store_Name>","<Brandname>","<Category>","<Condition>","<Material>","<Unsolditem>"
    And click on registration Submit
    #And click on Done and success msg with username "Tester swathi"
    And click on book a slot button
    Then Check and click on the store "<storeName>"
    And validate the date format
    And selct the time slot which is enable "<availableSlot>"
   # Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    Then validate contact fields "<contactName>" "<username>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on done
    Then confirmation email should sent with "Appointment Cancellation | weekday 2nd Hand Curated"

    Examples: 
      | Brand   | Country | Store             | Service                 | url                      | username             | password               | Store_Name                   | Brandname | Category | Condition | Material | Unsolditem              | storeName         | availableSlot | contactName | contactEmail              | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Automation Service Test | resale_portal_serviceurl | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | Drottninggatan 63 | 10:00         | Tester      | testerswathi135@gmail.com | +919876543210 | Marathalli     |          554678 | Banglore    | weekday@second.com |
