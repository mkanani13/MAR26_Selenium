package raghunathMate.puneFoodDelivery.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserAction {

    protected static WebDriver driver=null;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void  start(){
         start("CHROME","http://34.66.197.232/#/restaurants");
    }

    public static void start(String url) {
         start("CHROME",url);
    }

    public static void start(String browser, String url){
        switch(browser.toUpperCase()) {
            case "CHROME" :
                driver = new ChromeDriver();
                break;
            case "EDGE" :
                driver = new EdgeDriver();
                break;
            default :
                throw new RuntimeException("Invalid browser name, kindly give proper browser name");
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        actions = new Actions(driver);
        driver.get(url);
    }

    public static void closeBrowser()
    {
        driver.quit();
    }
}
