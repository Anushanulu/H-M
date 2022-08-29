@creatingB2Bseller
Feature: verify that seller level agreement is not there for newly added B2B seller

  Scenario Outline: Test seller level agreement is not there for newly added B2B seller
    Given User is login to Resale app with admin credentials
    And naviagte to manager users section and search with "<User>" and select "<Role>" and save it
    When user launch ResaleApp with valid credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And go to "<tab>" 
    And click on Add B2B sller button and enter the "<Name>" and save it
    

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab         |Name|
      | swetha.pr@storelens.com | Store User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | All Sellers |Tester1|
