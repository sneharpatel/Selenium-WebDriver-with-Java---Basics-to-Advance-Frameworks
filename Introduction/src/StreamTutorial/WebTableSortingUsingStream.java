package StreamTutorial;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingUsingStream {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
			
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// click on columns - because by default it is unsorted list so to take sorted list
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capture list of all webElements - into list
		
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		// capture text of all web elements - original list
		
		List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		System.out.println(originalList);
		
		// capture sorted text of all web elements - sorted list
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		System.out.println(sortedList);
		
		Assert.assertEquals(originalList, sortedList);
		
		List<String> price;
		
		do {
		// scan the name column with getText --> Rice --> print the price of the Rice
		// Pagination concept: so until it finds Rice, next page button will be clicked 
			List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
			price = elementsList.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getVeggiePrice(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			
		
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
				
		driver.close();		
	}

	private static String getVeggiePrice(WebElement s) {
		
		String veggiePrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return veggiePrice;
	}
 
}
