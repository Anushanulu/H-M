#Author: your.email@your.domain.com
#Keywords Summary : Store Open  Store Close
@2121_VerifyAdminStaffUserIsAbleToCloseStore
Feature: TC 2121 : Verify Admin Staff user is able to close the Store

  @TC_2121-Verify_Admin_Staff_user_is_able_to_close_the_Store
  Scenario Outline: Make sure User is able to open the store
    Given User Navigate to Booking App
    When User select "<country>" and "<brand>"
    When User Set "<brand>" "<country>" "<service>" "<defaultvisitors>"
    Then User Check "<Storestatus>" for "<StoreName>"
    Given User clicks on Calendar link
    Then User selects the store "<StoreName>" and clicks on Next
    And User click on toggle
    Then User click on Yes and able to see Successfully store Close Message

    Examples: 
      | brand   | country     | service | defaultvisitors | StoreName    | Storestatus |
      | WEEKDAY | Sweden      | Resell  |               3 | Hansa, Malmö | Store Open  |
      #| H&M     | netherlands | resale  |               5 | hansa        | Store close |
