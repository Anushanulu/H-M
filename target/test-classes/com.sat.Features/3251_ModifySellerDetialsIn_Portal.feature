@3251_ModifySellerDetilasInPortal
Feature: TC3251 : Check that modified Seller Details in Resale Portal are updated correctly in Resale App

  Scenario Outline: TC3251_Test  modified Seller Details in Resale Portal are updated correctly in Resale App
    Given user navigating go to login page "<url>" and click on Create an account link
    And enter mentioned fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page and click on Continue
    And login to Resale portal "<url>" and enter "<Email>" and password
    Then navigate to Personal Detials tab and update the details "<ModifyFName>","<ModifyLName>","<ModifyPHNBR>","<ModifyAddress>","<ModifyPincode>","<ModifyCity>" and save it
    And user launch the ResaleApp with valid credentials and signin and select "<Brand>","<Country>","<Store>"
    And search for the existing seller "<Email>","<tab>"
    And valiadte the seller details in app "<ModifyFName>","<ModifyLName>","<ModifyPHNBR>","<ModifyAddress>","<ModifyPincode>","<ModifyCity>"
    #Then remove created seller "<Email>"
    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | tab       | Brand   | Country | Store             | ModifyFName | ModifyLName | ModifyPHNBR | ModifyAddress | ModifyPincode | ModifyCity |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | All Items | WEEKDAY | Sweden  | Drottninggatan 63 | swetha pr   | PR          |  8641230976 | Lingampally   |        532865 | Hyderabad  |
