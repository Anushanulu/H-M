@2709_RelevantStoresList
Feature: TC2709 : Test whether user is able to see selected store for specific brand

  Scenario Outline: TC2709_verify user able to see selected store from the list
    Given User login to Resaleapp with admin credentials
    When select "<Brand>","<Country>","<Store>" and can able to see specific store which they selected

    Examples: 
      | Brand   | Country | Store             |
      | WEEKDAY | Sweden  | Drottninggatan 63 |
      #| monki | France  | Monki Passage Provence |
