Feature: Login User
  As a user,
  I want to check that I can log in to our e-commerce website,
  So that I can access my account.
 Background:
    Given the user is on the home page
    When User click on Register or login Button
  Scenario: Successful login with valid data
    When the user enters an valid username
    And the user enters a valid password
    And the user clicks on the login button
    Then the user should be redirected to Home Page
  Scenario: unsuccessful login with invalid data
    When the user enters an invalid username
    And the user enters a invalid password
    And the user clicks on the Login button
    And user clicks on login and signup Button
    Then The user should be redirected to login and signup not dashboard
  Scenario: unsuccessful login with empty data
    When user don't enter any data in username and password field and clicks on the Login Button
    And user clicks on login and signup button
    Then the user should be redirected to login and signup not Dashboard
