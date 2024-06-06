Feature: Validating SauseLab Mobile App Functionalities

  @NativeApp
  Scenario Outline: Validate login functionality
    Given launch the SauseLab Application
    And user click the Open menu
    And user click the login link
    When user enters the userid "<userid>"
    And user enters the password "<password>"
    When user clicks login button
    Then user should be taken to the products page

    Examples: 
      | userid          | password |
      | bob@example.com | 10203040 |

  @NativeApp
  Scenario: Validate product is added to the cart successfully
    Given launch the SauseLab Application
    And select the product "Sauce Labs Bolt T-Shirt"
    And click add to cart button
    When click the cart badge
    Then the selected product "Sauce Labs Bolt T-Shirt" should be added in My Cart page
