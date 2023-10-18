package rahulshettyacademy.abstractcomponents;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponent {
	
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;

	@FindBy(css="[routerLink*='myorders']")
	WebElement orderHeader;
	

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		//there is a By.id("") so that's why we use By findBy only
		
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		//there is a By.id("") so that's why we use By findBy only
		
	}
	
	// 5sec - Application issue
	// 1. there is 5 secs wait and code execution is slow down because of heavy traffic running on the application
	// so to speed up the execution we use Thread.sleep
	
	//2. there is a hidden spinner in the backend of app so it is waiting to get disappear and load all the ele
	
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		
		Thread.sleep(1000);

//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		//ng-animating is a class for loading, we have to wait until animating loading icon disappear
//		wait.until(ExpectedConditions.invisibilityOf(ele));
		
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))
		// there is a driver.findElement(By.cssSelector("")) i.e webElement so that's why we use ele
		
	}
	
	public CartPage goToCartPage() {
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	public OrderPage goToOrderPage(){
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

}
