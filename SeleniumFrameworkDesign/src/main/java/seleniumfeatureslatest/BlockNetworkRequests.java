package seleniumfeatureslatest;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;

import java.util.Optional;

public class BlockNetworkRequests {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
       long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("[routerlink*='/products']")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.className("add-to-cart")).click();
        String text = driver.findElement(By.className("sp")).getText();
        System.out.println(text);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        driver.close();


    }
}
