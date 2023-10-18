import java.time.Duration;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
	    
	    // wait until Multiple windows link loads and then click
	    WebElement link = driver.findElement(By.xpath("//*[@id='content']/ul/li[33]/a"));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/ul/li[33]/a"))); 
	    link.click();
	    
	    // click on click here link  and it will open new window
	    driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
	    
	    //  get the handles of all windows which are currently opened and return set of string and iterate over it 
	    Set<String> windows = driver.getWindowHandles();
	 	Iterator<String> it = windows.iterator(); 
	    
	    String parentId =  it.next(); // get parent window id
	    String childId = it.next();   // get child window id
	    
	    driver.switchTo().window(childId); // switch to child window
	    
	    //get text from child window
	    String childWindowText = driver.findElement(By.xpath("//*[@class='example']")).getText();
	    
	    // print text from child window
	    System.out.println(childWindowText); 
	    
	    // switch back to parent window
	    driver.switchTo().window(parentId);
	    
	    // get text from parent window
	    String parentWindowText = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
	    //print text from parent window 
	    System.out.println(parentWindowText);
	    
	}

}
