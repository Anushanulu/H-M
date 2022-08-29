@2864_BrandSettings
Feature: TC2864 : Verify user is able to see the updated brand settings

  Scenario Outline: TC2864_User able to see the updated brand settings
    Given user can launch ResaleApp with valid credentials and signin
    And Go to "<settings>" and select the "<Brand>" disable it and click on save
    And Go to "<settings>" and select the "<Brand>" the enable it
    And Update "<Store contact email>" and save it
    Then click on pencil icon and check "<Brand>","<Country>","<Store>" is now able to select

    Examples: 
      | settings       | Brand   | Store contact email    | Country | Store             |
      | Brand settings | WEEKDAY | testerswathi@gmail.com | Sweden  | Drottninggatan 63 |
