#Author: Swetha.pr@hcl.com
#Keywords Summary :
@TC_2839_2855_2858_Verify_User_gets_visitor_notification_email
Feature: TC 2839_2855_2858 : Verify user gets visitor notification email

  @TC_2839_2855_2858_Verify_User_gets_visitor_notification_email
  Scenario Outline: TC 2839_2855_2858 : Verify user gets visitor notification email
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
    Then select Slot Date "<setmonth>" "<setyear>" "<setDate>"
    #And validate the date format
    And selct the time slot which is enable "<availableSlot>"
    Then enter required contact details "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<contactPostcode>" "<contactCity>"
    Then validate contact fields "<contactName>" "<contactEmail>" "<contactMobile>" "<contactAddress>" "<helpmail>"
    Then click on done
    Then Run the cloud flow "VisitorsNotificationMailBeforeBookingday"
    And Validate confirmation mail with subject "Reminder of your appointment | weekday"

    Examples: 
      | Brand   | Country | storeName | serviceName | StoreStatus | fromDate | fromYear | fromMonth | todate | toYear | toMOnth | availableSlot | contactName | contactEmail           | contactMobile | contactAddress | contactPostcode | contactCity | helpmail           | setyear | setmonth | setDate |
      | WEEKDAY | Sweden  | Hansa     | Resell      | Store Open  |       11 |     2022 | May       |     11 |   2024 | May     | 11:00         | Swetha      | swethahcl960@gmail.com |     910812081 | tumkur         |          572102 | tumkur      | weekday@second.com |    2022 | August   |      25 |
