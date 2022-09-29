Feature: register user and search product functionality
  Scenario: user registers and search for a product
    Given user is on the home page of the website
    When user user navigates to the register page
    Then user fill all the required details and clicks the register button
    And user clicks the continue button
    And user provides the product input in the search box and clicks search button
    And the product searched is displayed
    And user logout and browser closes