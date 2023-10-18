import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// by using single array (list) how to add number of web elements

public class WebDriverMethods {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spicejet.com");
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println("No of links are: " + elements.size());
		
		elements = driver.findElements(By.tagName("img"));
		System.out.println("No of images are: " + elements.size());
		
		elements = driver.findElements(By.tagName("select"));
		System.out.println("No of dropdowns are: " + elements.size());
		
		//elements = driver.findElements(By.tagName(""));
		

	}

}
