import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); 
	   
	    System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	    System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	    
	    System.out.println("*****");
	    //driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled(); enabled method is not working
	    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	    driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	    System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	    
	    if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) 
	    	{ 
	    		System.out.println("It's enabled");
	    		Assert.assertTrue(true);
	    	
	    	}else {
	    		System.out.println("It's disbled");
	    		Assert.assertTrue(false);
	    	}
	    
	   

	    
	    
	    // count size of check box
	    
	   int checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	   System.out.println(checkBoxes);  
	    driver.findElement(By.id("divpaxinfo")).click();
	    Thread.sleep(2000L);
	    System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	 for(int i=1;i<5;i++)

	 {

	 driver.findElement(By.id("hrefIncAdt")).click();

	 }

	 driver.findElement(By.id("btnclosepaxoption")).click();
	 Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
