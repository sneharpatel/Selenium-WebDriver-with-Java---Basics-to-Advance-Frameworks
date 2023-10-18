package RahulShettyAcademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import testComponents.BaseTest;
import testComponents.Retry;


public class ErrorValidationTest extends BaseTest{
	
	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
 	public void  loginErrorValidation() throws InterruptedException, IOException {
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("simmy@gmail.com", "Iuserahulshettyacademy123qwe");
		String actual = landingPage.getToErrorMessage();
		Assert.assertEquals(actual, "Incorrect email or password.");// intentionally failed == need to add "or" between email and pw
	}

	@Test
	public void productErrorValidation() throws InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("seleniumtest1@gmail.com", "Password1234!");
		List<WebElement> productList = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
	}

}
