package seleniumfeatureslatest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.fetch.Fetch;

import java.util.Optional;

import static org.openqa.selenium.devtools.v117.fetch.Fetch.continueRequest;

public class NetworkMocking {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request ->
        {
            if (request.getRequest().getUrl().contains("=shetty")){

                String mockURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                System.out.println(mockURL);
                devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockURL),Optional.of(request.getRequest().getMethod()),
                        Optional.empty(),Optional.empty(), Optional.empty()));
            }else{
                devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(request.getRequest().getUrl()),Optional.of(request.getRequest().getMethod()),
                        Optional.empty(),Optional.empty(), Optional.empty()));
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        driver.close();
    }
}
