package seleniumfeatureslatest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class SetGeoLocation {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Map<String, Object> coordinates = new HashMap<String, Object>();
        // Madris, Spain = latitude =40, longitude=3
        coordinates.put("latitude", 40);
        coordinates.put("longitude", 3);
        coordinates.put("accuracy", 1);
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Netfilx", Keys.ENTER);
        driver.findElement(By.className("LC20lb")).click();
        String title = driver.findElement(By.xpath("//h1[contains(text(),'Unlimited movies,')]")).getText();
        System.out.println(title);


    }
}
