import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException, IOException {

        String downloadPath=System.getProperty("user.dir");
        WebDriverManager.chromedriver().setup();
        HashMap<String,Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.cssSelector("[class*='btn--choose']"));
        Thread.sleep(3000);
        // AutoIT is not supported on macBook, it only supports windows
        //fileupload.exe file contains all steps saved manually from AutoIT
        //https://www.udemy.com/course/selenium-real-time-examplesinterview-questions/learn/lecture/14660510#questions

        Runtime.getRuntime().exec("file path of fileupload.exe");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
        driver.findElement(By.cssSelector("button[class*='medium']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
        driver.findElement(By.linkText("Download Now")).click();

        Thread.sleep(5000);
        File f = new File("downloadPath+ /converted.zip");

        if(f.exists()){
            //System.out.println("file found");
            Assert.assertTrue(f.exists());
            if(f.delete()){
                System.out.println("file deleted");
            }
        }
    }
}
// set up from AUTO-IT:
// 1. shift focus to the file upload window
// 2. set text/path into file name edit box
// 3. click open to upload a file

// Au3info - record window component objects
// Build script: scite.exe
// save it -- .au3 extension
// convert file into .exe by compiling .au3 file
// call .exe file with RunTime class in Java into your selenium test