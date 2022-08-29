@2498_2495_ExpToInstore2ndTry
Feature: TC2498,2495: Check admin user is able to update the status from Expired to Instore2ndTry

  Scenario Outline: TC2498_2495_Verify Admin user is able to update the status from Expired to Instore2ndTry
    Given user is able to launch ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    When searching with the existing seller "<existingseller>","<tab>"
    And clickng on Add Item button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And clickng on "<status>" item and generate unique id by clicking on edit button and save it
    And clickng on "<status>" and fil details "zara","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And user is open the created item "In Store" and update the end of line item date with todays date as "2022","July","4"
    And run the cloudflow job "InStore_to_ExpiredItems"
    And navigating to "Expired" tab and check the item count
    And navigating to "<existingseller>","<tab>" open the "Expired" item and update the item to "<Updatedstatus>"
    And run the automatic cloudflow job for instore2ndtry "SendEmail_Seller_InStore2ndTry"
    And navigating to "Expired" tab and check the item count
		Then user will receive extend email as "Extend the sale of your garment(s) | Weekday Curated Secondhand"
																						
    Examples: 
      | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus    |
      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | In Store 2nd try |
      #| WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | Expired   |               1 | Pickup      | Pending | Broken           |
     # | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Unsold Picked Up Archived |
