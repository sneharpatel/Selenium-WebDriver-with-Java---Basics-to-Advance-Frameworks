import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		// 1. enter 'ind' in the input field
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(3000);
		
		// 2. get list of all the suggested countries and click on 'India'
		List<WebElement> suggestions = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		
		for(WebElement suggestion: suggestions) {
			String text = suggestion.getText();
			 
			if(suggestion.getText().equalsIgnoreCase("India")) {
				suggestion.click();
				break;
			}			
		}
		
		// 3. Verify that India is selected
		String expected = "India";
		String actualName = driver.findElement(By.cssSelector("input[id='autocomplete']")).getAttribute("value");
		System.out.println(actualName);
		Assert.assertEquals(actualName, expected);
		driver.close();

	}

}

/* why does  Line 35- System.out.println(driver.findElement(By.cssSelector("input[id='autocomplete']")).getText()) 
 * returns the null value  
 * whereas System.out.println(driver.findElement(By.cssSelector("input[id='autocomplete']")).getAttribute("value")) 
 * prints the selected text ?
 * 
 * Ans:  getText() method simply returns the visible text present between the start and end tags 
 * (which is not hidden by CSS). 
 * The getAttribute() method on the other hand identifies and fetches 
 * the key-value pairs of attributes within the HTML tags .  
 * I am referring to this HTML tag defined for the auto suggestive dropdown on this URL 
 * "https://rahulshettyacademy.com/AutomationPractice/"  -- ><input type="text" id="autocomplete" 
 * class="inputs ui-autocomplete-input" placeholder="Type to Select Countries" autocomplete="off" xpath="1"> 
 * and there is no attribute with the name 'Value' . 
 * 
 * 
 * Will it still display the value selected by user with getAttribute method ?
 * Yes
 * 
 * 
 * *** another way to handle this type of case is with JavascriptExecutor
 * 
 */




