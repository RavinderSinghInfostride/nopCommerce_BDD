Feature: HomePage functionalities

#  Scenario: user registers and search for a product
#    Given user is on the home page of the website
#    When user user navigates to the register page
#    Then user fill all the required details and clicks the register button
#    And user clicks the continue button
#    And user provides the product input in the search box and clicks search button
#    And the product searched is displayed
#    And user logout and browser closes
#
#  Scenario: user registers and add a desktop product to wishlist
#    Given user is on the home page of the website
#    When user user navigates to the register page
#    Then user fill all the required details and clicks the register button
#    And user clicks the continue button
#    And user navigates to the desktop page
#    And user adds a desktop product to wishlist
#    And user logout and browser closes

    Scenario: user registers and add product to cart and checkout
      Given user is on the home page of the website
      When user user navigates to the register page
      Then user fill all the required details and clicks the register button
      And user clicks the continue button
      And user navigates to the desktop page
      And user adds product to cart
      And user checkout from cart