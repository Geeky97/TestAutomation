@test
Feature: Add products to cart and verify details

  Scenario: User adds two products to the cart and verifies their details
    Given User is on the home page
    When User clicks 'Products'
    And User adds the first and second products to the cart
    Then User views the cart
    And Verifies both products are added with correct details


  Scenario: User verifies product quantity in the cart
    Given User is on the home page
    When User views a product
    And User verifies product details are opened
    And User increases quantity to 4
    And User adds the product to the cart
    And User views the cart
    Then User verifies the product is displayed with correct quantity

