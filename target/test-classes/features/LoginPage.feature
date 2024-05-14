@login
Feature: Login page feature

  @smoke @Regression
  Scenario: Login page title
    Given user is on login page
    When user gets title of the page
    Then page title should be "Swag Labs"

  @Regression
  Scenario: Login with Correct Credentials
    Given user is on login page
    When user enters userid "standard_user"
    And user enters password "secret_sauce"
    When user clicks on login button
    Then user should be landed to the products page
