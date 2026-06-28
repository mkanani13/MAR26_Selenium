package jayeshSonawane.technocreditsFoodAppWithFramework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.customexception.BrowserInvalidException;

import java.time.Duration;

public class BrowserActions {

    protected static WebDriver driver = null;
    protected static WebDriverWait wait ;
    protected static Actions actions;

    public static WebDriver start(){
        return start("chrome", "http://automationbykrishna.com/");
    }

    public static WebDriver start(String url) {
        return start("CHROME", url);
    }

    public static WebDriver start(String browserName, String url){
        System.out.println("Launch the browser and hit URL");

        switch (browserName.toUpperCase()){
            case "CHROME":
                driver = new ChromeDriver();
                break;

            case "EDGE":
                driver = new EdgeDriver();
                break;

            default:
                throw new BrowserInvalidException("Invalid Browser or Browser Not Supported");
        }

        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Removed implicit wait. Use explicit wait wherever possible.
        return driver;
    }

    public static void visibilityOfElementLocated(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static String visibilityOfElementLocatedText(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public static void close(){
        driver.quit();
    }
}
