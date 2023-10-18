package StreamTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
			
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.name("name"));
		
		WebElement nameLabel = driver.findElement(with(By.tagName("label")).above(nameEditBox));
		System.out.println(nameLabel.getText());
		
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		String studentLabel = driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText();
		System.out.println(studentLabel);
		
		driver.close();

	}

}
