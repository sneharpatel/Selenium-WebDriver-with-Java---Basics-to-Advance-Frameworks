import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();	    
	    driver.get("https://jqueryui.com/droppable/");
	    
	    WebElement ele = driver.findElement(By.cssSelector("iframe.demo-frame"));
	    driver.switchTo().frame(ele);
	    WebElement source = driver.findElement(By.id("draggable"));
	    WebElement destination = driver.findElement(By.id("droppable"));
	    
	    Actions a = new Actions(driver);
	    a.dragAndDrop(source, destination).build().perform();
	    driver.switchTo().defaultContent();
	    

	}

}
