import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JSExecutorPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollBy(0,500)");
	       
	    List<WebElement> values = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
	    
	    int sum = 0;
	    for(int i=0; i<values.size(); i++) {
	    	
	    	sum = sum + Integer.parseInt(values.get(i).getText());	    	
	    }
	    
	    System.out.println(sum);
	    int expected = 235;
	    
	    Assert.assertEquals(sum, expected);
		
	}

}
