@product
Feature: Adding products to the cart

  Background: 
    Given User has already login into the application
      | username      |  | password     |
      | standard_user |  | secret_sauce |

  @Regression
  Scenario Outline: Adding product to the cart
    Given user is on product page
    When user add the "<product>" to the cart
    And user clicks the cart button
    Then "<product>" should be available in the cart page
    When user click on the checkout button
    Then user should see the Checkout:Your information page
    And user provide the firstname "<Firstname>"
    And user provide the lastname "<Lastname>"
    And user provide the zipcode "<zipcode>"
    When user click the continue button
    Then user should see the checkout:overview page
    When user click the Finish button
    Then user should get the alert message as Thank you for your order!

    Examples: 
      | product                  |  | Firstname |  | Lastname |  | Zipcode |
      | Sauce Labs Backpack      |  | john      |  | walker   |  |  600040 |
      | Sauce Labs Bike Light    |  | peter     |  | zen      |  |  600045 |
      | Sauce Labs Fleece Jacket |  | Rock      |  | star     |  |  600048 |
