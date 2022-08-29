@3990_MultipleleItemsToOtherStore
Feature: TC3990 : Test user is able to change multiple items from one store to other store

  Scenario Outline: TC3990_Check whether user is able to change multiple items from one store to other store
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
    When User login to Resaleapp with admin credentials
    When selecting "<Brand>","<Country>","<Store>"
    And searching for existing seller "<existingseller>","<tab>"
    And go to Items tab and open the item which we have craeted
    And click on "Pre registered" item and generate id by clicking on edit button and save it
    And click on cancel button and ok
    And click on Done button
    And searching for existing seller "<existingseller>","<tab>"
    And go to Items tab and open the item which we have craeted
    # And open the "Pre registered" item and sign the agreeemnt
    And click on Add Item button and enter "<Number of Items>" and select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    And enter  "Biba","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    And enter  "Adidas","Men","Bags","40","Never worn ","Cotton","300","Drottninggatan 63","2023","October","13","Charity" and save it
    And user is open the created item "In Store" and update the end of line item date with todays date as "2022","July","5"
    And run the cloudflow job "InStore_to_ExpiredItems"
    And navigating to "<existingseller>","<tab>" open the "Expired" item and update the item to "<Updatedstatus>"
    And searching for existing seller "<existingseller>","<tab>"
    And click on "<status>" item and generate id by clicking on edit button and save it
    And enter  "Biba","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And user is open the created item "In Store" and update the end of line item date with todays date as "2022","July","5"
    And run the cloudflow job "InStore_to_ExpiredItems"
    And click on refresh button on right side of screen
    And searching for existing seller "<existingseller>","<tab>"
    And click on "<status>" item and generate id by clicking on edit button and save it
    And click on cancel button and ok
    And go to Items tab and open the item which we have craeted
    And collect the Items id for items
      | Pre registered   |
      | Pending          |
      | In Store         |
      | Expired          |
      | In Store 2nd try |
    And "<Change store>" for the selected items
    Then validate that item got changed to new store "<Brand>","<Country>","<Change store>"

    Examples: 
      | Service | url                | username             | password               | Store_Name                   | Brandname | Category | Condition | Material | Unsolditem              | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus    | Change store |  |
      | Resell  | resale_portal_url1 | resale_portal_userid | resale_portal_password | Drottninggatan 63, Stockholm | Biba      | Dresses  | Vintage   | Cotton   | Pick-up item from store | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               4 | Pickup      | Pending | In Store 2nd try | Hansa        |  |
