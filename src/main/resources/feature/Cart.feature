Feature: Cart functionality

  As a user
  I want to manage products in the cart
  So that I can proceed to checkout

  Background:
	And user logged in 
    And user navigates to the Products page
  Scenario: Add product to cart
    When user adds a product to the cart
    And user navigates to cart page
    Then selected product should be displayed in the cart
	
  Scenario: Remove product from cart
    Given selected product is already added to the cart
    When user removes the product from the cart
    Then product should be removed successfully