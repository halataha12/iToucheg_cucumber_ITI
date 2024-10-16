Feature: Add Product Functionality
  As a user shopper,
  I want to add products to my shopping cart,
  So that I can purchase them later when I'm ready to checkout.
  Background:
    Given the user is on the Home Page

  Scenario: Valid Registration and adding a product to the cart
    When the user is on the Registration page
    And the user enters valid credentials and click enter
    And the user searches for Valid Product Name in the search bar
    When the user clicks on the Add to Cart
    Then pop up displayed show product successfully added to cart

  Scenario: Adding product to the cart without being registered
    When the user searches for valid Product Name in the search bar
    And the user clicks on the add to cart
    Then Pop Up displayed show product successfully added to cart

