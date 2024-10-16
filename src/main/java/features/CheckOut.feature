Feature: checkOut functionality
  As a user,
  I want to complete my purchase by checking out my cart,
  So that I can buy the items I’ve added to my cart.

  Background:
    Given the user is Registered
    When The user search for item and Add item to cart
    And pop up displayed show Cart items and the user click on view Cart button
    And The user click proceed to cart
    Then the user navigates to check out page
  Scenario: User fills in billing information and proceeds with payment
    When the users enter their billing and shipping information
    And clicks Place order
    Then the order should be placed successfully and go to Order complete Page
  Scenario: User Attempts to checkout with missing billing details
    When the user does not fall in the required billing details and clicks pace order
    Then the user should see an error message indicating the missing fields
  Scenario: User fill coupon with don't exist coupon
    When user click on click here to enter you code
    And User puts Invalid code and clicks on button
    Then Message displayed says Coupon does not exist
