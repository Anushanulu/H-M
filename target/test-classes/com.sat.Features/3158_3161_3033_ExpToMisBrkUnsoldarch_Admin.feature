@3158_3161_3033_ExpToMisBrkUnsoldarchive
Feature: TC3158, 3161, 3033: Check admin user is able to update the status from Expired to Missing and Broken and Unsold pickup archeived

  Scenario Outline: TC3158_3161_3033_Verify Admin user is able to update the status from Expired to Missing and Broken and Unsold pickup archeived
    Given user able to launch ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    When searching for the existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate unique id by clcking on edit button and save it
    And click on "<status>" and fil details "Biba","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And user open the created item "In Store" and update the end of line item date with todays date as "2022","July","4"
    And run the cloudflow "InStore_to_ExpiredItems"
    Then go to "<existingseller>","<tab>" open the "Expired" item and update the item to "<Updatedstatus>"

    Examples: 
      | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus             |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Missing                   |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Broken                    |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Unsold Picked Up Archived |
