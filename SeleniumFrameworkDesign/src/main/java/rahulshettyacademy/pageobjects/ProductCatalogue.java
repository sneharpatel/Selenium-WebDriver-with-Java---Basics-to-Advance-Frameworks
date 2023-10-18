package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.abstractcomponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		//driver initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageFactory
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//driver.findElement(By.cssSelector(".ng-animating"))
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	//By addToCart = By.cssSelector(".card-body button.btn.w-10.rounded");
	By toastMessage = By.id("toast-container");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;	
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		System.out.println(prod);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		
		WebElement prod = getProductByName(productName);
		Thread.sleep(2000);
		prod.findElement(addToCart).click();
		Thread.sleep(2000);
		//waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
	}


}
