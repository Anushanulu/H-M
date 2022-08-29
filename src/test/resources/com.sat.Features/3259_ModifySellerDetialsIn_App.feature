@3259_ModifySellerDetilasInPortal
Feature: TC3259 : Check that modified Seller Details in Resale Portal are updated correctly in Resale App

  Scenario Outline: TC3259_Test  modified Seller Details in Resale Portal are updated correctly in Resale App
    Given user navigating go to login page "<url>" and click on Create an account link
    And enter mentioned fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page and click on Continue
    Given user launch the ResaleApp with valid credentials and signin and select "<Brand>","<Country>","<Store>"
    And search for the existing seller "<existingseller>","<tab>"
    
    
    #Then remove created seller "<Email>"

    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore |
      

   
