Feature: User Registration
  As a user,
  I want to check that I can register on our e-commerce website,
  So that I can create an account to make purchases and manage my orders.
  Background:
    Given the user in the home page
    When I click on Register or login Button

  Scenario: User Registration with Accepted Email and  Password
    And I entered EmailAddress ,Password and click on Register Button
    Then the user Registered successfully

  Scenario: User Registration with not Accepted Email and Accepted Password
    And I entered not accepted email and accepted Password and click on Register Button
    Then the user can not Register


