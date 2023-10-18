
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		
		
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		
		int count = dates.size();
		
		
		while(!driver.findElement(By.cssSelector("div[class='flatpickr-current-month']")).getText().contains("January")) {
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();	
		}
		
		for(int i=0; i<count; i++) {
			
			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
			
			System.out.println(text);
			
			if(text.equalsIgnoreCase("21")) {
				
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				
				break;
			}
		}
	}

}
