import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;


public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollBy(0,500)");
	    
	    js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	   
	    
	    List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	    int sum =0;
	    for(int i=0; i<values.size(); i++) {
	    	
	    	sum = sum + Integer.parseInt(values.get(i).getText());
	    	 
	    } 
	    System.out.println(sum);
	    
	    System.out.println(driver.findElement(By.className("totalAmount")).getText());
	    
	    int total = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
	    
	    Assert.assertEquals(sum, total);
	}

}
