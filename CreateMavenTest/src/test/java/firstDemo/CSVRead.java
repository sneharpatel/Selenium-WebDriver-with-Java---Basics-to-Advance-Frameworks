package firstDemo;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class CSVRead {
	
	public static void main(String[] args) throws Exception {
	
		System.setProperty("webDriver.chrome.driver", "/Users/sneha/drivers/chromedriver_mac64");	
		WebDriver driver = new ChromeDriver();
		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
		driver.get(url);
		
		System.out.println(readData());
		
		String uname = readData().get(0);
		String pwd = readData().get(1);
		
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public static List<String> readData() throws IOException {
		
		String csv_file = "/Users/sneha/eclipse-workspace/CreateMavenTest/src/PracticeDataSheet - TestData1.csv";
		
		CSVReader reader = new CSVReader(new FileReader(csv_file)); 
		
		for(String[] s: reader.readAll()) {
			return Arrays.asList(s)	;
			
		}
		 
		return new ArrayList<String>();
						
	}

}




