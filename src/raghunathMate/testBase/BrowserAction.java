package raghunathMate.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserAction {
    private static WebDriver driver = null;

    public static WebDriver start() {
         return start("CHROME", "http://automationbykrishna.com/");
    }

    public static WebDriver start(String url) {
        return start("CHROME", url);
    }

    public static WebDriver start(String browser, String url) {

        switch(browser.toUpperCase()) {
            case("CHROME") :
                driver = new ChromeDriver();
                break;
            case("EDGE") :
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name, Kindly give proper bowser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(url);
        return driver;
    }
}
