package smratiGarg.PageFactory.base;
.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import smratiGarg.PageFactory.customeException.BrowserInvalidException;

import java.time.Duration;

public class BrowserAction {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public static void start() {
        start("http://automationbykrishna.com");
    }

    public static void start(String url) {
        start(url,"CHROME");
    }

    public static void start(String url, String browser) {
        System.out.println("STEP - Launch browser & hit url");

        driver = switch (browser.toUpperCase()) {
            case "CHROME" -> new ChromeDriver();
            case "EDGE" -> new EdgeDriver();
            default -> throw new BrowserInvalidException("Given browser not supported");
        };

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        driver.manage().window().maximize();
        driver.get(url);

        //return driver;
    }

    public static void quit(){
        driver.quit();
    }

    protected void clickOnElement (WebElement we){
        clickOnElement(we, false);
    }
    protected void clickOnElement(WebElement we, boolean isWaitRequire){
        if (isWaitRequire)
            wait.until(ExpectedConditions.elementToBeClickable(we));
        we.click();
    }

    protected void setText (WebElement we, String text){
        setText(we,text, false);
    }
    protected void setText (WebElement we, String text, boolean isWaitRequire ){
        if(isWaitRequire)
            wait.until(ExpectedConditions.visibilityOf(we));
        we.sendKeys(text);
    }

    protected void getText (WebElement we, boolean isWaitRequire){
        if(isWaitRequire)
            wait.until(ExpectedConditions.visibilityOf(we));


    }

}
