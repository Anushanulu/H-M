@3162_ResalRegistration

Feature: TC3162 : Registering a seller in Resale portal

  Scenario Outline: TC3162_Register a seller
    Given user naviagtes to login page "<url>" and click on Create an account link
    And check create account page should have required fields
    And enter all the mandatory fileds "<Email>" and  "<Firstname>" and "<Lastname>" and "<Mobile>" and "<Street Address>" and "<Postal code>" and "<City>" in the page
    And click on Continue
    Then remove created seller "<Email>"

    Examples: 
      | url                | Email             | Firstname | Lastname | Mobile     | Street Address | Postal code | City     |
      | resale_portal_url1 | swetha.pr@hcl.com | Swetha    | pr       | 9876543210 | Marathalli     |      554678 | Banglore |
      #|resale_portal_url1|sriswathianusha.nulu@gmail.com|Anusha|Nulu|9876543210|Kukatpally|537828|Hyderabad|
      #| resale_portal_url1 | testerswathi135@gmail.com | HCLtester@22 | Tester    | swathi   | 9876543210 | Marathalli     |      554678 | Banglore |
