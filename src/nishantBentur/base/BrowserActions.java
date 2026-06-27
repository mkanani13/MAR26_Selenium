package nishantBentur.base;

import nishantBentur.customException.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class BrowserActions {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;
    protected static Actions actions;


    public static WebDriver start(String browser, String url) {

        System.out.println("STEP- Launch the browser and hit the URL");

        switch (browser.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "EGDE":
                driver = new EdgeDriver();
                break;
            default:
                throw new InvalidBrowserException("Browser is not supported");
        }

        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        return driver;
    }

    public static WebDriver start() {
        return start("CHROME", "http://34.66.197.232/#/access");
    }

    public static WebDriver start(String url) {
        return start("CHROME", url);
    }

    public static void closeBrowser() {
        driver.close();
    }
}
