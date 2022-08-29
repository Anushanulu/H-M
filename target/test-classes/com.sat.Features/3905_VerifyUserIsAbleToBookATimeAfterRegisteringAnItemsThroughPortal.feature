#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_3905_Verify_user_is_able_to_book_a_time_after_registering_an_items_through_portal
Feature: TC 3905 : Verify user is able to book a time after registering an items through portal

  @TC_3905_Verify_user_is_able_to_book_a_time_after_registering_an_items_through_portal
  Scenario Outline: TC 3905 : Verify user is able to book a time after registering an items through portal
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<Store>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<Service>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
    And select brand "<Brand>" and country "<Country>"
    And Select store "<Store>"
    And click on "<Service>" Settings
    Then check the display in portal view is "Enable" for the service
    When User navigates to ResalePortal "<url>" login page
    And user enters valid ResalePortal "<username>" and "<password>"
    And click on signin
    And veify success msg with username "Tester swathi"
    And click on Registeryouritems
    And user select or enter below fields "<Store_Name>","<Brandname>","<Category>","<Condition>","<Material>","<Unsolditem>"
    And click on registration Submit
    #Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And validate the date format
    And selct the time slot which is enable "<availableSlot>"
    And validate Registered Items details "<Brand>" "<Category>"
    And validate Booking details "<Store>" "<setyear>" "<setmonth>" "<setDate>" "Tester" "<username>"

    Examples: 
      | Brand   | Country | Store             | Service | url                | username             | password               | Store_Name                   | Brandname | Category | Condition | Material | Unsolditem              | setyear | setmonth | setDate | availableSlot | StoreStatus |
      | WEEKDAY | Sweden  | Drottninggatan 63 | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store |    2022 | August   |      11 | 10:00         | Store Open  |
