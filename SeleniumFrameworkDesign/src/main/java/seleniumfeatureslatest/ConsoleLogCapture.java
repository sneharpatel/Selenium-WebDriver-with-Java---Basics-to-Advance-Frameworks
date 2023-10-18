package seleniumfeatureslatest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogCapture {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.cssSelector("[routerlink*='/products']")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.className("add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        // get javaScript logs from browser window
       LogEntries entries = driver.manage().logs().get(LogType.BROWSER); // get LogEntries object
       List<LogEntry> logs = entries.getAll(); // LogEntry object - getAll method will return all logs
        for(LogEntry e : logs){ // iterate over logs to get message for each log
            System.out.println(e.getMessage());
        }
        driver.close();
    }
}
