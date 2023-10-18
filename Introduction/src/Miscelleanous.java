import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.*;

public class Miscelleanous {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().deleteAllCookies();
	    driver.manage().deleteCookieNamed("specific cookie name: sessionKey");
	    
	    // Session time out Scenario: where deleting specific cookie will log you out from the app
	    // click on any link
	    // verify it will take you on log-in page
	    
	    driver.get("https://www.google.com");
	    
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	    //FileUtils.copyFile(src, new File("/Users/sneha/screenshot.png"));
	    FileHandler.copy(src,new File("/Users/sneha/screenshot.png"));
	    driver.close();
	    
	}

}
