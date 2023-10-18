package RahulShettyAcademy.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("simmy@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iuserahulshettyacademy123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream().filter(product->
				product.findElement(By.cssSelector("b")).getText()
						.equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//ng-animating is a class for loading, we have to wait until animating loading icon disappear
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		//driver.findElement(By.xpath("//button[@class='btn-custom']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match); // need to change JDK version in pom.xml file too, 1.8 from 1.7
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		// go to check out page and select country from auto suggestive list,  
		// get order completion text and verify text
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
//		JavascriptExecutor js = (JavascriptExecutor)driver; 
//	    js.executeScript("window.scrollBy(0,1000)");
		
	   // driver.findElement(By.cssSelector(".action__submit")).click();
	    
	    WebElement placeOrder = driver.findElement(By.cssSelector(".action__submit"));

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    js.executeScript("arguments[0].click();", placeOrder);
	    
	    // for reference
		//driver.findElement(By.xpath("//a[contains(@text(),'Place Order')]")).click();
		 //driver.findElement(By.xpath("//*[text()='Place Order']")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmMessage);
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		
	
		driver.close();
		
		
		
		

	}

}
