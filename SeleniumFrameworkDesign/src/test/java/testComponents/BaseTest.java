package testComponents;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import rahulshettyacademy.pageobjects.LandingPage;
import org.testng.annotations.*;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
	
		// Properties class
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "/src/main/java/resources/GlobalData.Properties");
		
		prop.load(fis);
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser"): prop.getProperty("browser");
		System.out.println(browserName);

		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")){
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen recommended dimension

		} else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox
			System.setProperty("webdriver.gecko.driver", "/Users/sneha/drivers/geckodriver");
			driver = new FirefoxDriver();
		}else {
			// edge
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenShot(String testcaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "// reports //" + testcaseName + ".png");
		FileUtils.copyFile(source,file);
		return (System.getProperty("user.dir") + "// reports //" + testcaseName + ".png");
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {

		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);

		//  string to hashMap : jackson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return data; // list of HashMap
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
