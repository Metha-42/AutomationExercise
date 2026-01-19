Feature: Checkout process

  As a logged-in user
  I want to checkout products
  So that I can place an order

  Background:
    And user is logged in
    And product is added to the cart

  Scenario: Checkout with logged-in user
    When user proceeds to checkout
    Then address details page should be displayed
    And order summary should be visible

  Scenario: Checkout without login
    Given user is not logged in
    When user tries to access checkout
    Then user should be redirected to login or signup page