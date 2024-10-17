@test
Feature: Verify All Products and Product Detail Page functionality

  Scenario: User views details of a selected product
    Given User is on the home page
    When User clicks 'Products'
    Then ALL PRODUCTS page is displayed
    And The products list is visible
    When User clicks View Product for the first item
    Then Product detail page is displayed with all product details

Scenario: User Searches for a Product
  Given User is on the home page
  When User clicks 'Products'
  Then ALL PRODUCTS page is displayed
  And Enters a product name in the search input and clicks the search button
  Then The user verifies that SEARCHED PRODUCTS is visible
  And Confirms that the relevant products are displayed

