
@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Negative test for checking error message

    Given I landed on Ecommerce Page
    When Logged in with username <email> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | email           | password               |
      | simmy@gmail.com | Iuserahulshettyacademy |
