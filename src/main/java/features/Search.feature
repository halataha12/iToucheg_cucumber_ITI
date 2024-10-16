Feature: Search For Products Functionality
  As a user,
  I want to search for products on the e-commerce website,
  So that I can quickly find and view the items I am interested in purchasing.

  Background:
     Given the user in home Page
  Scenario: valid product search
    When The user searches for valid Product Name in the search bar
    Then The user should see a list of products
  Scenario: invalid product search
    When The user searches for invalid product name in the search bar
    Then The user should see a message no products found




