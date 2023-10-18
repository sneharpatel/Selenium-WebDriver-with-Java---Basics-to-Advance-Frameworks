import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement suggestion = driver.findElement(By.id("autosuggest"));
		suggestion.sendKeys("Ind");
		Thread.sleep(2000);
		//List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(WebElement option: options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
				}
			
		}
		
		driver.close();
	}
	

}
