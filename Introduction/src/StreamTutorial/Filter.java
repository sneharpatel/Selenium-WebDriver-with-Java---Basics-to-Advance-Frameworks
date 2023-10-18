package StreamTutorial;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filter {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
			
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
	
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filterList = veggies.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filterList.size());

		driver.close();
	}

}
