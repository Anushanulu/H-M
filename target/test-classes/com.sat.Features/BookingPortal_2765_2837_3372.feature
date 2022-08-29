#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_2765_2837_3372_Verify_Customer_is_able_to_book_the_Slot__in_Booking_Portal_and_get_confirmation_email
Feature: TC 2765_2837_3372 : Verify Customer is able to book the Slot in Booking Portal and get Confirmation email

  @TC_2765_2837_3372_Verify_Customer_is_able_to_book_the_Slot__in_Booking_Portal_and_get_confirmation_email
  Scenario Outline:TC 2765_2837_3372 : Verify Customer is able to book the Slot in Booking Portal and get confirmation email
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
    #Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    And validate the date format
    And selct the time slot which is enable "<availableSlot>"
    Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on done
    And Validate confirmation mail with subject "Appointment Confirmation | weekday"

    Examples: 
      | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           |
      | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 10:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |
