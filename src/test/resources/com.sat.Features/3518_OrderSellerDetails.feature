@3518_OrderSellerDetails
Feature: TC3518 : Test that seller details are dispalyed in alphabetical order

  
  Scenario Outline: TC3518_Check seller details are dispalyed in alphabetical order
    Given user launches ResaleApp with valid credentials and signin
    When selects "<Brand>","<Country>","<Store>" and go to "<tab>"
    Then Verify SHOW ALL SELLERS link and click on the same and navigate to Seller Name column and check sellers are displaying in alphabetical order
    

    Examples: 
      | User                    | Brand   | Country | Store             | tab         |
      | swetha.pr@storelens.com | WEEKDAY | Sweden  | Drottninggatan 63 | All Sellers |
