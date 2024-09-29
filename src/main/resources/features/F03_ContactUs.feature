Feature: Contact Us form

  Scenario: Submit contact form and return to home page

    Given User is on the home page
    When User navigates to Contact Us page
    And User submits contact form
    Then Verify success message is displayed
    And User returns to home page

