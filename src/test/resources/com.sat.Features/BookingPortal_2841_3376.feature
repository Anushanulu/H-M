#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_2841_3376_Verify_User_gets_booking_cancellation_email_for_Rental_Portal_booking
Feature:TC 2841_3376 : Verify User gets booking cancellation email for Rental Portal booking

  @TC_2841_3376_Verify_User_gets_booking_cancellation_email_for_Rental_Portal_booking
  Scenario Outline:TC 2841_3376 : Verify User gets booking cancellation email for Rental Portal booking
    Given Login to Admin tool App
    Then change the Country "<Country>" and brand "<Brand>"
    When clicked on store Calendar then select store "<storeName>" and check the "<StoreStatus>"
    Then check calendar is generated for the "<serviceName>" if not generate calendar "<fromDate>" "<fromYear>" "<fromMonth>" "<todate>" "<toYear>" "<toMOnth>"
    When navigate to store settings
    When select brand "<Brand>" and country "<Country>"
    Then Select store "<storeName>"
    And click on "<serviceName>" Settings
    Then check the display in portal view is "Enable" for the service
    And open booking portal url
    Then Check and click on the store "<storeName>"
    And validate the date format
    And selct the time slot which is enable "<availableSlot>"
    Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on Cancle Booking Button and click on Yes verify cancelled msg and "<helpmail>"
    And Validate confirmation mail with subject "Appointment Cancellation | weekday"

    Examples: 
      | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           |
      | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |    9108120810 | tumkur         |          572102 | tumkur      | weekday@second.com |
