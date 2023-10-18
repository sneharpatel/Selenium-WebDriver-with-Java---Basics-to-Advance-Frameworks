
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.*;

public class FluentWaitTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.heroku.app.com/dynamic_loading/1"); // this url is not working
		driver.findElement(By.cssSelector("[id='start'] button")).click();

		WebElement finishButton = driver.findElement(By.cssSelector("[id='finish'] h4"));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		// in fluent wait, there is no any in-build methods that we can use directly so
		// we have to
		// we need to build customize wait method based on condition

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				if (finishButton.isDisplayed()) {
					return finishButton;

				} else {
					return null;
				}

			}
		});

		System.out.println(finishButton.getText());

	}

}
