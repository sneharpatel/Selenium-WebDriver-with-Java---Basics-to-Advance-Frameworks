import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();

		// http://qaclickacademy.com/practice.php - url navigating to following url
		// https://rahulshettyacademy.com/AutomationPractice/

		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. select option3 check box
		WebElement option3chkbx = driver.findElement(By.xpath("//*[@id='checkBoxOption3']"));
		option3chkbx.click();

		// 2. Grab the selected text - Option3
		WebElement option3 = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/fieldset/label[3]"));
		String option3chkbxText = option3.getText();
		System.out.println(option3chkbxText);

		// select drop-down box
		WebElement selectDropDown = driver.findElement(By.id("dropdown-class-example"));
		selectDropDown.click();

		Select dropDown = new Select(selectDropDown);

		// 3. enter Option3 from step 2
		dropDown.selectByVisibleText(option3chkbxText);

		System.out.println(dropDown.getFirstSelectedOption().getText());

		// 4. enter text from step2 into enter your text field

		WebElement textFld = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));
		textFld.click();

		textFld.sendKeys(option3chkbxText);
		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);

		// 5. Verify text grabbed from step 2 is present in the pop up message
		//Assert.assertTrue(alertText.contains(option3chkbxText));
		
		if(alertText.contains(option3chkbxText)) {
			System.out.println("Text is present in alert");
		}else {
			System.out.println("Text is not present in alert");
		}

		// driver.switchTo().alert().accept();

	}

}
