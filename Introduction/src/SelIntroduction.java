import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		//Invoke the browser
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
    WebDriver driver = new ChromeDriver();
		
	// seleniumManager = will take care of system.setproperty by turning on selenium manager - 
	//System.setProperty("webDriver.gecko.driver", "/Users/sneha/drivers");	
	
	//WebDriver driver = new FirefoxDriver();
	
	// MS edge browser
	
	// System.setProperty("webdriver.edge.driver", "/Users/sneha/msedgedriver");

	// WebDriver driver2 = new EdgeDriver();
	
    driver.get("https://rahulshettyacademy.com/");
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
    driver.close();
    
		
    

	}

}


// Udemy video 10: Interview questions included