import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUps {
    public static void main(String[] args){
        //System.setProperty("webDriver.chrome.driver", "/Users/sneha/ChromeDriver_v118/chromedriver-mac-arm64");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //· Handling Window Authentication Pop Up:
        // use this format: http://Username:Password@SiteURL

        //https://the-internet.herokuapp.com/
        //driver.get("https://the-internet.herokuapp.com/");
        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
        driver.close();
    }
}
