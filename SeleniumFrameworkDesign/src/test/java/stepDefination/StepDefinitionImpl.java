package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import rahulshettyacademy.pageobjects.*;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public  ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void iLandedOnEcommercePage() throws IOException {
        landingPage = launchApplication();
    }

   @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String username, String password){
        productCatalogue = landingPage.loginApplication(username, password);
   }

   @When("^I add product (.+) to cart$")
       public void I_add_product_to_cart(String productName) throws InterruptedException {
        List<WebElement> productList = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
       }

   @When("^Checkout (.+) and submit the order$")
   public void checkout_submit_the_order(String productName){
       CartPage cartPage = productCatalogue.goToCartPage();
       boolean match = cartPage.verifyProductDisplay(productName);
       System.out.println(productName);
       System.out.println(match);
       Assert.assertTrue(match); // need to change JDK version in pom.xml file too, 1.8 from 1.7
       CheckOutPage checkOutPage = cartPage.goToCheckOut();
       checkOutPage.selectCountry("India");
       confirmationPage = checkOutPage.submitOrder();
   }

   @Then("{string} message is displayed on ConfirmationPage")
    public void confirmation_message_displayed_on_confirmationPage(String string) {
       String confirmMessage = confirmationPage.getConfirmationMessage();
       Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
       driver.close();
   }

   @Then("{string} message is displayed")
    public void error_message_displayed(String string1){
       String actual = landingPage.getToErrorMessage();
       Assert.assertEquals(actual, string1);
       driver.close();
   }



}


 // "tidy gherkin" is the chrome plugin to convert feature file into step definition