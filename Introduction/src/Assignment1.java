import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    
	    // 1. Check the first  Checkbox and verify if it is successfully checked and 
	    //Uncheck it again to verify if it is successfully Unchecked
	    
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
	    driver.findElement(By.id("checkBoxOption1")).click();
	   Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
	   System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	   
	   driver.findElement(By.id("checkBoxOption1")).click();
	   Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
	   System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	   
	   
	   
	   //2. Count the number of checkboxes
	   
	   int checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	   System.out.println(checkBoxes);
	   driver.close();
	   
	    
	}

}
