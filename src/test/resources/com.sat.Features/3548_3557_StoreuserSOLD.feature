@3548_3557_storeUserSOLD
Feature: TC3548,3557 : Test Store user is able to update the status to SOLD

  Scenario Outline: TC3548_3557_Verify status is upadted to SOLD when login with store user
    Given user login to ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    When search with existing seller "<existingseller>","<tab>" and click on Add Item button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And click the "<status>" item and generate unique id by clcking on edit button and save it
    And click the "<status>" and fil details "Adidas","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And naviagte to manage users section and search for "<User>" and select role to "<Role>" and save it
    Then user logging into ResaleApp and search for "<existingseller>","<tab>" update created item "In Store" to "<Updatedstatus>"

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus |
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Sold          |
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Broken        |
