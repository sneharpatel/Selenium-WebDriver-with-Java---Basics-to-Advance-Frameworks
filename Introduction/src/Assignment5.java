import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
	    
	    driver.findElement(By.linkText("Nested Frames")).click();
	    
	    WebElement ele = driver.findElement(By.name("frame-top"));
	    System.out.println(ele.getText());

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("frame-top")));
	    
	    driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame("frame-top");
	    driver.switchTo().frame("frame-middle");
	    
	    WebElement ele1 = driver.findElement(By.xpath("//*[@id=\'content\']"));
	   System.out.println(ele1.getText());
	    	    

	}

}
