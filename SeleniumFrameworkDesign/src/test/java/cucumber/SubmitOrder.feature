
@tag
  Feature: Purchase the order from E-commerce website
    I want to use this template for my feature file

    Background:
      Given I landed on Ecommerce Page

    @Regression
    Scenario Outline: Positive test for submitting the order

      Given Logged in with username <email> and password <password>
      When I add product <productName> to cart
      And  Checkout <productName> and submit the order
      Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

      Examples:
        | email           | password                  | productName |
        | simmy@gmail.com | Iuserahulshettyacademy123 | ZARA COAT 3 |


