import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    
	    
	    //1. count of links on the web-page
	    //2. count of links on footer section
	    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    
	    System.out.println(driver.findElements(By.tagName("a")).size());
	    
	    WebElement footerLink = driver.findElement(By.id("gf-BIG")); // limiting web-driver scope 
	    
	    System.out.println(footerLink.findElements(By.tagName("a")).size());
	    
	    //3. count first column footer links
	    
	    WebElement firstFooterCol = footerLink.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	    
	    //List<WebElement> links = firstFooterCol.findElements(By.tagName("a"));
	    
	    int a = firstFooterCol.findElements(By.tagName("a")).size();
	    
	    System.out.println(a);
	    
	    // 4. click on each link of footer first column
	    for(int i=1; i<a; i++) 
	    	{
	    	
	    	String clickOnLinkTab = Keys.chord(Keys.COMMAND, Keys.RETURN);
	    	firstFooterCol.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
	    	
	    	Thread.sleep(5000L);
	    	}
	    	
	    	// 5. get each tab title
	    	Set<String> windows = driver.getWindowHandles();
	    	
	    	Iterator<String> it = windows.iterator();
	    	
	    	while(it.hasNext()) {
	    		driver.switchTo().window(it.next());
	    		System.out.println(driver.getTitle());
	    	}	    	    
	}

}
