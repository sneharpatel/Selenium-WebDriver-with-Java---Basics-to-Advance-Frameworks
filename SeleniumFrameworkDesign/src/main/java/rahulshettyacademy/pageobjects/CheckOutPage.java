package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		selectCountry.click();
		
		 
	}
	
	public ConfirmationPage submitOrder() {
		WebElement placeOrder = submit;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", placeOrder);
		
		 ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		 return confirmationPage;
				 
		
	}
	
	
	

}
