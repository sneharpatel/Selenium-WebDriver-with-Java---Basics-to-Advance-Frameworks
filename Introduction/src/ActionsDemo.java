import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
		.sendKeys("hello").doubleClick().build().perform();
		
		//right click - with contextClick() method
		// move cursor to specific element = moveToelement(target element)
		a.moveToElement(move).contextClick().build().perform();
		
		// Drag and Drop

	}

}
