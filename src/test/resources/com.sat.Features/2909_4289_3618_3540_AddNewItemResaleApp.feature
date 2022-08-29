@2909_4289_3618_3540_AddingNewItem
Feature: TC2909,4289,3618,3540 : Test user able to receives email when add a new item with 'Pending' status and check admin able to update all information and update the status to Sold

  Scenario Outline: TC_2909_4289_3618_3540_Verify user able to receives email when new item is added  with 'Pending' status and check admin able to update all information and update the status to Sold
    Given user launching ResaleApp with valid credentials and signin
    When selecting "<Brand>","<Country>","<Store>"
    And searching for existing seller "<existingseller>","<tab>"
    And click on Add Item button and enter "<Number of Items>" and select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    Then user will receive email as "You’re all Set | Weekday Curated Secondhand"
    And click on "<status>" and enter  "Biba","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And open the created item "In Store" and update all details including price "Adidas","Men","Bags","40","Second hand","Plastic","400","Drottninggatan 63","2024","October","15","Pickup"
    And select "<Brand>","<Country>","<Store>"
    And naviagte to manage users section and search with "<User>" and select role to "<Role>" and save it
    Then user login to ResaleApp and search for "<existingseller>","<tab>" update created item "In Store" to "<Updatedstatus>"

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus |
      | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Sold          |
