import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	    
	    //Drop down with select tag - static
	    WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	    
	    
	    Select dropdown = new Select(staticDropdown);
	    
	    dropdown.selectByIndex(3); // this will select USD
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    dropdown.selectByValue("AED");
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    dropdown.selectByVisibleText("INR");
	    System.out.println(dropdown.getFirstSelectedOption().getText());
	    

	}

}
