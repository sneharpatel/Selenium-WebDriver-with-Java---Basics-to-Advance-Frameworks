package seleniumfeatureslatest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.emulation.Emulation;

import java.util.Optional;

public class MobileEmulatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // send command to CDP methods ==> CDP methods will invoke and get access to chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
                Optional.empty() , Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty()));
        // https://blogs.oracle.com/java/post/optionals-patterns-and-good-practices
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Library"));
        driver.close();
    }

}
