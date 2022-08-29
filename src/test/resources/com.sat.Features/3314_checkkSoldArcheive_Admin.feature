@3314_CheckSoldArchieveByAdmin
Feature: TC3314 : Test user able to receives email when add a new item with Pending status and check admin able to update all information and update the status to SoldArchieve

  Scenario Outline: TC3314_Verify user able to receives email when new item is added  with 'Pending' status and check admin able to update all information and update the status to SoldArchieve
    Given user able to launch ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And searching for existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    And click on "<status>" and enter  "nike","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And open the created item "In Store" to "<Updatedstatus>"
    And run the job "SendEmail_Seller_SoldToWaitingForPayOut"
    And run the job "Seller_WaitingForPayOutToSoldArchive"
    And click on refresh button
    And searching for existing seller "<existingseller>","<tab>"
    Then open the created item "Sold Archive" and check the status

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus |
      | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Sold          |
