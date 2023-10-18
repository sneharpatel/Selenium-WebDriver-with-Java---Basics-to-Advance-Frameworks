package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	WebDriver driver;
	
	// List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	
	public boolean verifyProductDisplay(String productName) {
		
		boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOut() {
		checkOut.click();
		CheckOutPage checkout = new CheckOutPage(driver);
		return checkout;
	}

}
