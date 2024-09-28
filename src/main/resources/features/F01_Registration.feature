@test2
Feature: F01_Registration | guest use could create new accounts


  Scenario: user could create new account with valid data

    Given User is on home page
    Then User go to register page
    When User enter name & email
    And Click sign up button
    Then User should see ENTER ACCOUNT INFORMATION visible
    When User select title
    And  User fills account information with name, email, password, and DOB
    And User selects Sign up for our newsletter! checkbox
    And User selects Receive special offers from our partners! checkbox
    And User fills personal details First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And User clicks Create Account button
    Then ACCOUNT CREATED! should be visible
    When User clicks Continue button
    Then Logged in as username should be visible
    When User clicks Delete Account button
    Then ACCOUNT DELETED! should be visible
    And User clicks Continue button


  Scenario: Signup with already registered email address

    Given User is on the home page
    When The user clicks on the Signup_Login button
    Then The New User Signup page should be visible
    When User enters name and already registered email address
    And The user clicks the Signup button
    Then Verify error Email Address already exist! is visible