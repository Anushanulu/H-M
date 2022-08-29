@manageruser
Feature: Test admin user able to change the role

  Scenario Outline: Verify admin user is able to change the role of the user
    Given User login to Resale portal admin credentials
    When go to manager users section
    And search with "swetha.pr@storelens.com" and select the "<Role>","<Brand>","<Country>","<Store>" and save it
    Then check user able to see success message


    Examples: 
      | Role       | Brand   | Country         | Store             |
      | Brand User | WEEKDAY | Sweden          | Drottninggatan 63 |
      #| Store User | H&M     | The Netherlands | H&M Middelburg    |
      
     # testing
