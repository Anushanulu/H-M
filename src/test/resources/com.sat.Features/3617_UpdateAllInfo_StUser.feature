@3617UpdateallInfobyStoreuser
Feature: TC3617: Check store user is not able to update the price

  Scenario Outline: TC3617_Verify Store user is not able to update price
    Given User is login to Resale app with admin credentials
    When selecting "<Brand>","<Country>","<Store>"
    And search with existing seller "<existingseller>","<tab>"
    And click on AddItem button and enter "<Number of Items>", select "<Unsold Item>" and click Next button and enter sign save it
    And click on "<status>" item and generate id by clicking on edit button and save it
    And click the "<status>" and fil details "Adidas","Women","Hats","42","Never worn ","Leather","500","Drottninggatan 63","2023","November","30","Charity" and save it
    And naviagte to manager users section and search with "<User>" and select "<Role>" and save it
    And user launch ResaleApp with valid credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And search with existing seller "<existingseller>","<tab>"
    Then click on "In Store" and check "price" field is disable

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab       | Number of Items | Unsold Item | status  |
      #| swetha.pr@storelens.com | Admin      | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending |
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Items |               1 | Pickup      | Pending |
