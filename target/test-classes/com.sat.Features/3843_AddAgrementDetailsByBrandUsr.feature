@3843_AddAgreementDetailsByBrandUser
Feature: TC3843 : Test Brand user is able to see add agreement details

  Scenario Outline: TC3843_Check Brand user is able to see add agreement details
    Given User is login to Resale app with admin credentials
    And naviagte to manager users section and search with "<User>" and select "<Role>" and save it
    When user launch ResaleApp with valid credentials and signin and selecting "<Brand>","<Country>","<Store>"
    And go to "<tab>"
    And check the brand value is matching with the selected "<Brand>" 
    Then click on add agreeemnt button and check that brand value is displaying

    Examples: 
      | User                    | Role       | Brand   | Country | Store             | existingseller            | tab              |
      | swetha.pr@storelens.com | Brand User | WEEKDAY | Sweden  | Drottninggatan 63 | testerswathi135@gmail.com | Manage Agreement |
