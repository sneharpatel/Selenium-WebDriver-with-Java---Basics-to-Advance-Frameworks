package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver); // passing driver to the parent class by super and 
		//for that e have to create a constructor in parent
		
		//driver initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement email = driver.findElement(By.id("userEmail"));
	
	// pageFactory
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getToErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		String errorMessageText = errorMessage.getText();
		return errorMessageText;
			
	}

}
