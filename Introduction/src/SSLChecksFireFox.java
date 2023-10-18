import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class SSLChecksFireFox {

	public static void main(String[] args) {
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
	
		
		System.setProperty("webdriver.gecko.driver", "/Users/sneha/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.close();

	}

}


// https://chromedriver.chromium.org/capabilities - refer this link for chromeOptions class
