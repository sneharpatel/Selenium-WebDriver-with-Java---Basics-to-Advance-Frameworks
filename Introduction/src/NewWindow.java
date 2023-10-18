import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    
	    driver.get("https://rahulshettyacademy.com/angularpractice/"); 
	    
	    // open new Tab use --> WindowType.TAB
	    // to open new window use --> WindowType.WINDOW
	    driver.switchTo().newWindow(WindowType.TAB);
	    
	    // get window ids
	    
	    Set<String> windows= driver.getWindowHandles();
	    
	    Iterator<String> it = windows.iterator();
	    
	    String parentId = it.next();
	    String childId = it.next();
	    
	    // switch to child window
	    driver.switchTo().window(childId);
	    // enter the url into new window
	    driver.get("https://courses.rahulshettyacademy.com/");
	    
	    // get text of course
	    
	   String courseName = driver.findElement(By.cssSelector("a[href*='/p/core-java-for-automation-testers']")).getText();
	   
	   System.out.println(courseName);
	   
	   //switch back to parent window and enter course name
	   
	   driver.switchTo().window(parentId);
	   WebElement name = driver.findElement(By.name("name"));
	   name.sendKeys(courseName);
	   
	   // screenshot of webElement not a web page 
	   
	   File file = name.getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(file, new File("logo.png")); // in Miscellaneous file
	   
	   
	   // get height and width of webElement
	   
	   System.out.println(name.getRect().getDimension().getHeight());
	   System.out.println(name.getRect().getDimension().getWidth());
	   driver.close();

	}

}
