package RahulShettyAcademy.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import rahulshettyacademy.pageobjects.*;
import testComponents.BaseTest;

public class SubmitOrderTest  extends BaseTest{

	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void  submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> productList = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		boolean match = cartPage.verifyProductDisplay(input.get("product"));
		System.out.println(input.get("product"));
		System.out.println(match);
		Assert.assertTrue(match); // need to change JDK version in pom.xml file too, 1.8 from 1.7
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		tearDown();
	}
	String productName = "ZARA COAT 3";
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest(){
		ProductCatalogue productCatalogue = landingPage.loginApplication("simmy@gmail.com", "Iuserahulshettyacademy123");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderListDisplay(productName));
	}


	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/data/PurchaseOrder.json");
		return new Object[][]{ {data.get(0)},{data.get(1)} };
	}
//	@DataProvider
//	public Object[][] getData(){
//		return new Object[][] {{"simmy@gmail.com","Iuserahulshettyacademy123","ZARA COAT 3"},{"seleniumtest1@gmail.com", "Password1234!","ADIDAS ORIGINAL"}};
//	}

// 		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","simmy@gmail.com");
//		map.put("password","Iuserahulshettyacademy123");
//		map.put("product","ZARA COAT 3");
//
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email","seleniumtest1@gmail.com");
//		map1.put("password","Password1234!");
//		map1.put("product","ADIDAS ORIGINAL");

}
