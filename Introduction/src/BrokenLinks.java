import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();

		// broken URL:
		// 1. is to get all urls tied up to the links using selenium
		// Java methods will call urls and get status codes
		// if status code is >400 then taht url is not working --> link with tied to the
		// uel is broken
		// "a[href*='brokenlink']" ==> 404 code, 'soapui' ==> 200 code

//	    String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//	    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
//	    
//	    conn.setRequestMethod("HEAD");
//	    conn.connect();
//	    int responseCode = conn.getResponseCode();
//	    
//	    System.out.println(responseCode);
//	    driver.close();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollBy(0,5000)");
		

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {

			String url1 = link.getAttribute("href");

			try {
			HttpURLConnection conn1 = (HttpURLConnection) new URL(url1).openConnection();
			conn1.setRequestMethod("HEAD");
			conn1.connect();
			int responseCode1 = conn1.getResponseCode();

			System.out.println(responseCode1);
			
			a.assertTrue(responseCode1 < 400, "The link with text: " + link.getText() + " is broken link with code " + responseCode1);

			} catch(Exception e) {
				System.err.println("Error while checking link " + url1 + ": " + e.getMessage());

                a.fail("Error while checking link " + url1);
				
			}
//			if (responseCode1 > 400) {
//
//				System.out.println("The link with text: " + link.getText() + " is broken link with code " + responseCode1);
//
//				Assert.assertTrue(false);
//
//			}

		}
		
		a.assertAll();

		driver.close();

	}

}
