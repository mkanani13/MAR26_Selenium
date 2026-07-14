package vishwajeetLoni.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vishwajeetLoni.customExceptions.BrowserNotSupportedException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import vishwajeetLoni.customExceptions.BrowserNotSupportedException;
import java.time.Duration;

public class ActionOnBrowser {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;  // declaing variable for wait
    protected static Actions actions;

    public static WebDriver start(){  // used for launching Automation by Krishna site each time
        start("CHROME","http://automationbykrishna.com");  // calling the overloaded method from below and launching automation by krishna when no parameters passed
        return driver;

    }

    public static WebDriver start (String url) {  // used to launch browser when only URL is passed
       start("CHROME",url);  // again calling below method where Browser is constant and URL changes
        return driver;
    }

    public static WebDriver start (String browser,String url) {

        switch (browser.toUpperCase()){   // using switch case to accommodate users when Browser and URL are passed as parameters
            case "CHROME":
                driver = new ChromeDriver();
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                break;

            case "EDGE":
                driver = new EdgeDriver();
                break;

            default:
                throw new BrowserNotSupportedException("Given browser not supported");  // created a custom exception to handle the invalid browser entry

        }
        driver.get(url);
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
        return driver;
    }

    public static void quitBrowser(){
        driver.close();
    }

    protected WebElement waitForElementVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected List<WebElement> waitForAllElementVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitForElementToBe(By by, int num){
        wait.until(ExpectedConditions.numberOfElementsToBe(by,num));
    }

    protected WebElement waitForElementToBeClickable(By by){
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementVisibility(String locatorType,String locator){
        switch (locatorType.toUpperCase()){
            case "XPATH" :
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            case "ID" :
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));

            case "NAME" :
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));

            case "LINKTEXT" :
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));

        }
        return null;
    }

}
