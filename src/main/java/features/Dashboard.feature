Feature: Verify Dashboard
  As a user,
  I want to verify the dashboard,
  So that I can ensure that all relevant data and features are displayed correctly.

  Background:
    Given the user is registered and in Dashboard Page
  Scenario: Ensure correct navigation to orders page
    When the user clicks on the orders link
    Then the user should be navigated directly to the orders page
  Scenario: Ensure correct navigation to downloads page
    When the user clicks on the downloads link
    Then the user should be navigated directly to the downloads page
  Scenario: Ensure correct navigation to Addresses page
    When the user clicks on the Addresses link
    Then the user should be navigated directly to the Addresses page
  Scenario: Ensure correct navigation to Account details page
    When the user clicks on the Account details link
    Then the user should be navigated directly to the Account details page
  Scenario: Ensure correct navigation to My Coupons  page
    When the user clicks on the My Coupons link
    Then the user should be navigated directly to the My Coupons page
