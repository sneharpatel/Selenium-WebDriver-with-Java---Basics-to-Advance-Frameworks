import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();

		// WebDriver driver = new SafariDriver();
		String[] items = { "Nokia Edge", "Blackberry", "iphone X", "Samsung Note 8" };

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		Thread.sleep(2000);
//	    System.out.println(driver.switchTo().alert().getText());
//	    driver.switchTo().alert().accept();
		// System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.id("okayBtn")).click();
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));

		Select s = new Select(dropdown);
		s.selectByVisibleText("Consultant");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-img-top")));

		addItems(driver, items);

		driver.findElement(By.cssSelector("a.btn-primary")).click();

		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.btn-success")));

		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn-success")).getText(), "Checkout");

		driver.close();

	}

	public static void addItems(WebDriver driver, String[] items) {

		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < products.size(); i++) {

			int j = 0;

			String s = products.get(i).getText();

			System.out.println(s);

			List<String> itemList = Arrays.asList(items);

			if (itemList.contains(s)) {

				j++;

				driver.findElement(By.xpath("//button[contains(text(), 'Add ')]")).click();

				if (j == itemList.size()) {

					break;
				}

			}

		}

	}

}
