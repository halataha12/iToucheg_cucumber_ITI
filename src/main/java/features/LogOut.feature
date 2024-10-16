Feature: LogOut Functionality
  As a user,
  I want to log out of my account,
  So that I can securely end my session and protect my information.

  Scenario: logout user
    Given the user is on the home Page
    And The user is Registered
    When The user navigate to Dashboard
    And clicks on logout
    And user clicks to confirm Logout
    Then the user Logged out successfully
