@3799_4244_4291_3319_IBANnumberValidation
Feature: TC3799,4244,4291,3319 : Test whether user is able to activate sign agreement for new seller with valid IBAN number and not saved with invalid IBAN number

  Scenario Outline: TC3799_4244_4291_3319_verify user is able to save the seller with valid IBAN number and not saved with invalid IBAN number
    Given user go to login page "<url>" and click on Create an account link
    And enter the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    And click on Continue button
    When user navigating to ResaleApp with valid credentials and signin
    And select "<Brand>","<Country>","<Store>"
    And search for existing seller "<existingseller>","<tab>"
    And select checkboxes and give "<invIBANNumber>" and save it
    And select the both of the checkboxes and enter the "<validIBANnumber>" and save it
    And validate the IBAN number "<validIBANnumber>"
    Then Login to Resalepportal "<url>","<Email>" and delete the created seller

    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     | existingseller    | tab         | invIBANNumber   | validIBANnumber | Brand   | Country | Store             |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | swetha.pr@hcl.com | All Sellers | invSbIBANnumber | sbIBANnumber    | WEEKDAY | Sweden  | Drottninggatan 63 |
     # | resale_portal_url2 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | swetha.pr@hcl.com | All Sellers | invNlIBANnumber    | nlIBANnumber    | H&M     | The Netherlands | H&M Amsterdam Noord |
      #| resale_portal_url3 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore | swetha.pr@hcl.com | All Sellers | invMonkiIBANnumber | monkiIBANnumber | monki   | Sweden          | Hansa               |
