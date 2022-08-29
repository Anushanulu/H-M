@3703_BranduserNotSeenAdminOption
Feature: TC3703 : Test Brand user is not able to see Admin option 
  Scenario Outline: TC3703_Verify that user Admin option is not available for Brand user
    Given user launch ResaleApp with admin credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And go to manage users section and search with "<User>" and select role to "<Role>" and save it
    And user login to ResaleApp and selecting "<Brand>","<Country>","<Store>"
    And naviagting to manage users section and search with "<User>"

    Examples: 
      | Brand   | Country | Store             | User                    | Role       |   existingseller            | tab       | Number of Items | Unsold Item | status  | Updatedstatus |
      | WEEKDAY | Sweden  | Drottninggatan 63 | swetha.pr@storelens.com | Brand User |   testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending | Sold          |
