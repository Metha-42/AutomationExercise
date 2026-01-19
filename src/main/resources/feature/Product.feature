Feature: Product search and details

  As a user
  I want to search and view products
  So that I can decide what to purchase

  Background:
    Given  user navigates to the Products page

  Scenario: Search product with valid keyword
    And  user enters product name in search box
    And user clicks on search button
    Then matching products should be displayed

  
  Scenario: View product details
    When user clicks on searched product
    Then product details page should be displayed
    And product name, price, and availability should be visible