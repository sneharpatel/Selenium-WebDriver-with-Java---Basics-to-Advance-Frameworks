import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    
	   // drop down, edit-boxes, error validation
	    // input fields
	    driver.get("https://rahulshettyacademy.com/angularpractice/");
	    driver.findElement(By.name("name")).sendKeys("Sneha");
	    driver.findElement(By.name("email")).sendKeys("sneha123@gmail.com");
	    driver.findElement(By.id("exampleInputPassword1")).sendKeys("pwd123");
	    
	    //click check box
	    driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	    
	    // select gender
	    WebElement selectGender = driver.findElement(By.id("exampleFormControlSelect1"));
	    Select dropDown = new Select(selectGender); 
	    dropDown.selectByVisibleText("Female");	 
	    
	    // click radio button
	    driver.findElement(By.id("inlineRadio1")).click();
	    
	    // select b'date - current date
	   // driver.findElement(By.className("form-control")).click();
	    driver.findElement(By.xpath("//input[@type='date']")).click();
	    //driver.findElement(By.xpath("//input[@name='bday']")).click();
	    
	    driver.findElement(By.name("bday")).sendKeys("02/02/1992");

	    driver.findElement(By.cssSelector(".btn-success")).click();

	    System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
	    
	    // click submit button 
//	    driver.findElement(By.cssSelector("input[type='submit']")).click();
//	    
//	    
//	    
//	    WebElement alert = driver.findElement(By.className("alert-success"));
//	    System.out.println(alert.getText());
//	    
//	    String alertActualText = alert.getText();
//	    String result[] = alertActualText.split(" ");
//	    for(int i=0; i<result.length;i++) {
//	    	System.out.println(result[i]);
//	    }
	    
	   // System.out.println(alertActualText.trim());
//	    String expectedText = "Success! The Form has been submitted successfully!.";
//	    Assert.assertEquals(alertActualText, expectedText);
	    		    
//	    if(alertActualText.contains("Success! The Form has been submitted successfully!.")) {
//	    	System.out.println("User has successfully submitted form");
//	    }
	}

}
