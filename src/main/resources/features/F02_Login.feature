@test2
Feature: F02_Login |  Login and Logout functionality on AutomationExercise

  Scenario: Login User with correct email and password

    Given User is on the home page
    When The user clicks on the Signup_Login button
    Then The Login to your account page should be_visible
    When User enter valid email address & password
    And The user clicks the login button
    Then User should be visible Logged in as username

  Scenario: Login user with incorrect email and password

    Given User is on the home page
    When The user clicks on the Signup_Login button
    Then The Login to your account page should be_visible
    When User enters incorrect email address & password
    And The user clicks the login button
    Then Verify error Your email or password is incorrect! is visible


  Scenario: Login and Logout user

    Given User is on the home page
    When The user clicks on the Signup_Login button
    Then The Login to your account page should be_visible
    When User enter valid email address & password
    And The user clicks the login button
    Then User should be visible Logged in as username
    And The user clicks the logout button
    Then Verify user is navigated to login page










