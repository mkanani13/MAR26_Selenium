package jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.base;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPageFactory.customExceptions.BrowserInvalidException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import technocredits.customexception.BrowserInvalidException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BrowserActions {

    protected static WebDriver driver;
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

    // wait till element located
    public WebElement visibilityOfElementLocated(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // wait for number of windows to be
    public void waitForNumberOfWindowsToBe(int count){
        wait.until(ExpectedConditions.numberOfWindowsToBe(count));
    }

    // Find Element
    private WebElement getElement(By by, boolean isWaitRequired){
        if(isWaitRequired){
            return visibilityOfElementLocated(by);
        }
        return driver.findElement(by);
    }

    // get page title
    protected String getPageTitle(){
        return driver.getTitle();
    }

    // send keys
    protected void sendKeysToElement(By by, String text, boolean isWaitRequired){
        WebElement e = getElement(by, isWaitRequired);
        e.sendKeys(text);
    }

    protected void sendKeysToElement(WebElement element, String value, boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        element.sendKeys(value);
    }

    // Click
    protected void clickOnElement(By by, boolean isWaitRequired){
        WebElement e = getElement(by, isWaitRequired);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    protected void clickOnElement(WebElement element,  boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        element.click();
    }

    // get Element Text
    protected String getElementText(By by, boolean isWaitRequired){
        WebElement e = getElement(by, isWaitRequired);
        return e.getText();
    }

    protected String getElementText(WebElement element, boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return element.getText();
    }

    // select Dropdown value and retrieve the text
    protected String selectDropdownElementByVisibleText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return select.getFirstSelectedOption().getText();
    }

    // select Dropdown value and retrieve the text
    protected String selectDropdownElementByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
        return select.getFirstSelectedOption().getText();
    }

    // arrow keys up
    protected void sendKeysArrowUp(int quantity){
        for (int count = 0; count<quantity; count++){
            actions.sendKeys(Keys.ARROW_UP).perform();
        }
    }

    // arrow keys down
    protected void sendKeysArrowDown(int quantity){
        for (int count = 0; count<quantity; count++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
    }

    // get attribute value
    protected int getAttributeValue(WebElement element, String attributeName){
        return Integer.parseInt(element.getAttribute(attributeName));
    }

    // is element displayed
    protected boolean isElementDisplayed(By by, boolean isWaitRequired){
        WebElement e = getElement(by, isWaitRequired);
        return e.isDisplayed();
    }

    protected boolean isElementDisplayed(WebElement element, boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return element.isDisplayed();
    }

    // is element enabled
    protected boolean isElementEnabled(By by, boolean isWaitRequired){
        WebElement e = getElement(by, isWaitRequired);
        return e.isEnabled();
    }

    protected boolean isElementEnabled(WebElement element, boolean isWaitRequired){
        if(isWaitRequired){
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        return element.isEnabled();
    }

    // get Page ID
    protected String getPageId(){
        return driver.getWindowHandle();
    }

    // get All Page IDs
    protected Set<String> getAllPageIds() {
        return driver.getWindowHandles();
    }

    // switch to window
    protected void switchToWindow(String id){
        driver.switchTo().window(id);
    }

























//    public static String visibilityOfElementLocatedText(By by){
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
//    }

    public static JavascriptExecutor scrollTo(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

        return js;
    }

    public static void printElement(List<WebElement> element){
        if(!element.isEmpty()){
            for (WebElement e : element){
                System.out.println("Selected Option is : " + e.getText());
            }
        }else {
            System.out.println("No Option Selected");
        }
    }
    public static Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public static void takeScreenshot(String fileName){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("src/jayeshSonawane/technocreditsFoodAppWithFrameworkPageFactory/screenshots/"+fileName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(){
        driver.quit();
    }
}
