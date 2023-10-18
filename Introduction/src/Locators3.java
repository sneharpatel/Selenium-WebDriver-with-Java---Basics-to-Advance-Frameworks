import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();

	    // sibling - child to parent traverse
	    // //header/div/button[1]/following-sibling::button[1]
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    String buttonText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
	    System.out.println(buttonText);
	    
	    // traverse from child to parent : same log in button by different ways
	    System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
