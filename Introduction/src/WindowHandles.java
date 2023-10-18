import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.Iterator;
public class WindowHandles {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		WebElement para = driver.findElement(By.cssSelector(".im-para.red"));
		
		String paraText = para.getText();
		
		System.out.println(paraText);
		
		String emailId = paraText.split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentId);
		
		driver.findElement(By.id("username")).sendKeys(emailId);
		
		
		
		
		
		
		

	}

}
