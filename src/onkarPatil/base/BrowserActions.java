package onkarPatil.base;

import onkarPatil.customExceptions.BrowserInvalidException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserActions {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public static WebDriver start(){
        return start("CHROME", "http://34.66.197.232/#/access");
    }

    public static WebDriver start(String url){
        return start("CHROME", url);
    }

    public static WebDriver start(String browser, String url){
        System.out.println("STEP- Launch browser and hit url");
        switch(browser.toUpperCase()){
            case "CHROME" :
                driver = new ChromeDriver();
                break;

            case "EDGE" :
                driver = new EdgeDriver();
                break;

            default :
                throw new BrowserInvalidException("Given browser is not supported");
        }
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        return driver;
    }

    public static void quitBrowser(){
        driver.close();
    }

    protected static void setText(WebElement e, String text, Boolean isWaitRequired){
        if(isWaitRequired){
            waitUntilElementIsVisible(e);
        }
        e.sendKeys(text);
    }

    protected static String getTextOfElement(WebElement e, Boolean isWaitRequired){
        if(isWaitRequired){
            waitUntilElementIsVisible(e);
        }
        return e.getText();
    }

    protected static String getAttributeFromElement(WebElement e, String attribute, Boolean isWaitRequired){
        if(isWaitRequired){
            waitUntilElementIsVisible(e);
        }
        return e.getAttribute(attribute);
    }

    protected static void waitUntilElementIsVisible(WebElement e){
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    protected static void waitUntilElementIsClickable(WebElement e){
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    protected static void clickOnElement(WebElement e, Boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.elementToBeClickable(e));
        }
        e.click();
    }

    private static WebElement getElement(By by){
        return driver.findElement(by);
    }

    protected static void clickOnElement(By by, Boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        WebElement e = getElement(by);
        clickOnElement(e, false);
    }

    protected static void selectOptionFromDropdownByVisibleText(WebElement e, String text){
        Select select = new Select(e);
        select.selectByVisibleText(text);
    }

    protected static void selectOptionFromDropdownByValue(WebElement e, String value){
        Select select = new Select(e);
        select.selectByValue(value);
    }

    protected static void scrollToElement(WebElement e){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", e);
    }
}
