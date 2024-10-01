@test1
Feature: Verify All Products and Product Detail Page

  Scenario: Verify All Products and Product Detail Page functionality
    Given User is on the home page
    When User clicks 'Products'
    Then ALL PRODUCTS page is displayed
    And The products list is visible
    When User clicks View Product for the first item
    Then Product detail page is displayed with all product details

