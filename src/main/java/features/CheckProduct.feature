Feature: Search for a product and view its details
  As a user,
  I want to search for a product and view its details,
  So that I can make an informed decision before purchasing.
  Background:
    Given the user is on the Home page
    When the user enters product in the search bar and clicks on search button
    Then the search results page for products is displayed
  Scenario: View available product details
    When the user clicks on the product which add to cart is visible
    Then the product details page is displayed
    And the user check the price of the product
    And the product is available with the status In Stock
    And the user can Add Product To cart
  Scenario: View unavailable product details
    When the user clicks on the product which add to cart is invisible
    Then The product details page is displayed
    And the user check the price of the Product
    And the product status is Out of Stock
    And the user is prompted to Notify when stock available with the option to provide an email and phone number.