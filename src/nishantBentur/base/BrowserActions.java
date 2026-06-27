package nishantBentur.base;

import nishantBentur.customException.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserActions {
    protected static WebDriver driver = null;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriver start() {
        return start("CHROME", "http://automationbykrishna.com/");
    }

    public static WebDriver start(String url) {
        return start("CHROME", url);
    }

    public static void closeBrowser() {
        driver.close();
    }
}
