import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import org.openqa.selenium.Proxy;

public class SSLChecks {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		
		// 1. for SSL checks 
		options.setAcceptInsecureCerts(true);
		
		// 2. for proxy server
		
		// Add the WebDriver proxy capability.

		Proxy proxy = new Proxy();

		proxy.setHttpProxy("Ipaddress:3337");
		
		options.setCapability("proxy", proxy);
		
		// 3. block pop-up windows for e.g flight booking web-sights where you may get location enable pop up
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		// 4. set download directory
		
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");

		options.setExperimentalOption("prefs", prefs);
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.close();

	}

}

// https://chromedriver.chromium.org/capabilities - refer this link for ChromeOptions class and in-built methods
