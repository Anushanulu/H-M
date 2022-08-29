@3167_ResalForgotpassword
Feature: TC3167 : Validate when user forgot the password

  Scenario Outline: TC3167_Verify when user is forgot the password
    Given User navigating to login page "<url>"
    When click on forgot password link
    And enter email id "<username>" and click on Reset button
    Then success message should dispaly
    And An email sent to register email address with subject as "Password reset request |  2nd Hand Curated"
    And click on Reset passowrd and update it
    Then An email sent to register email address with subject as "Your password was updated |  Curated Secondhand"

    Examples: 
      | url                | username             |
      | resale_portal_url1 | resale_portal_userid |
