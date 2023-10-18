import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		// 1. Print no.of rows ==> should be 11
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println(rows.size());

		// 2. Print no. of columns ==> should be 3
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display tr th"));
		System.out.println(columns.size());

		// 3. Print content of row 2
		List<WebElement> row2Values = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));

		for (int i = 0; i < row2Values.size(); i++) {
			System.out.println(row2Values.get(i).getText());

		}

		driver.close();
	}

}
