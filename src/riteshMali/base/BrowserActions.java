package riteshMali.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.customexception.BrowserInvalidException;

import java.time.Duration;

public class BrowserActions {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public static void start() {
        start("CHROME", "http://34.66.197.232/#/access");
    }

    public static void start(String url) {
        start("CHROME", url);
    }

    public static void start(String browser, String url) {
        System.out.println("STEP - Launch browser & hit url");
        switch (browser.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                break;

            case "EDGE":
                driver = new EdgeDriver();
                break;

            default:
                throw new BrowserInvalidException("Given browser not supported");
        }

        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

    }

    public static void quitBrowser() {

        driver.close();
    }

    protected WebElement waitForElementVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}
