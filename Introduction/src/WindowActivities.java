import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");	
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://google.com");
	    driver.navigate().to("https://rahulshettyacademy.com/");
	    driver.navigate().back();
	    driver.navigate().forward();
	    
	    
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    //1. SCROLLING BY USING PIXEL
	    
	    js.executeScript("window.scrollBy(0,1000)", "");
	    
	    //2. scrolling page till we find element
	    WebElement xyz;
	    
	    //js.executeScript("arguments[0].scrollIntoView();", xyz);
	    
	    // 3. scrolling page till bottom 
	    
	    js.executeScript("window.scrollTo(0,documnet.body.scrollHeight)");
	    
	    
	    
	    
	    

	}

}
