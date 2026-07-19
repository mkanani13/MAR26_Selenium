package technocredits.technoapp.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.customexception.BrowserInvalidException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * OOPS: Method overloading - Same method name but different parameters
 * OOPS: Encapsulation - Hiding the implementation details and providing a public interface for interaction
 * OOPS: Abstraction - Abstract class providing a blueprint for browser actions without exposing implementation details
 */


public abstract class BrowserActions {

    private static WebDriver driver = null;
    private static WebDriverWait wait;
    protected static Actions actions;

//    private BrowserActions(){}

    public static WebDriver start() {
        return start("CHROME", "http://automationbykrishna.com");
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void mouseHoverAndClick(WebElement mouseHoverElement, WebElement clickElement) {
        actions.moveToElement(mouseHoverElement).click(clickElement).clickAndHold(clickElement).perform();
    }

    public static WebDriver start(String url) {
        return start("CHROME", url);
    }

    public static WebDriver start(String browser, String url) {
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
//		driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    protected WebElement waitForElementVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitUntilElementMoreThen(By by, int num) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, num));
    }

    protected WebElement waitForElementVisibility(By by, boolean shouldWait) {
        if (shouldWait)
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        else
            return driver.findElement(by);
    }

    protected WebElement waitForElementVisibility(WebElement element, boolean shouldWait) {
        if (shouldWait)
            return wait.until(ExpectedConditions.visibilityOf(element));
        else
            return element;
    }

    protected List<WebElement> waitForAllElementVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void waitForElementToBe(By by, int num) {
        wait.until(ExpectedConditions.numberOfElementsToBe(by, num));
    }

    protected WebElement waitForElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForElementVisibility(String locatorType, String locator) {
        switch (locatorType.toUpperCase()) {
            case "XPATH":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            case "ID":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));

            case "NAME":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));

            case "LINKTEXT":
                return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));

        }
        return null;
    }

    public static void quitBrowser() {
        driver.quit();
    }

    public static void takeScreenshot(String methodName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("src/technocredits/technoapp/failedScreenshot/" + methodName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void setTextOnElement(WebElement element, String text) {
        WebElement ele = waitForElementVisibility(element, true);
        if (ele.isEnabled())
            ele.sendKeys(text);
        else
            throw new ElementNotInteractableException("Element is not interactable");
    }

    protected void setTextOnElement(By by, String text) {
        waitForElementVisibility(by, false).sendKeys(text);
    }

    protected void clickOnElement(WebElement element) {
        waitForElementToBeClickable(element).click();
    }

    protected void clickOnElement(By by) {
        waitForElementToBeClickable(by).click();
    }

    protected List<String> getAllOptionsFromDropDown(By by) {
        Select select = new Select(waitForElementVisibility(by));
        List<WebElement> elementList = select.getOptions();
        List<String> options = new ArrayList<>();
        for (WebElement element : elementList) {
            options.add(element.getText());
        }
        return options;
    }

    protected List<WebElement> getAllElements(By by) {
        return waitForAllElementVisibility(by);
    }

    protected int getSizeOfElements(By by) {
        return getAllElements(by).size();
    }

    protected void selectByVisibleText(By by, String dropDownVisibleText) {
        Select locationSelect = new Select(waitForElementVisibility(by));
        locationSelect.selectByVisibleText(dropDownVisibleText);
    }

    protected boolean isElementDisplayed(By by) {
        try {
            return waitForElementVisibility(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isElementDisplayed(By by, boolean shouldWait) {
        try {
            if (shouldWait) {
                return waitForElementVisibility(by).isDisplayed();
            } else {
                return driver.findElement(by).isDisplayed();
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected String getTextFromElement(By by) {
        return waitForElementVisibility(by).getText().trim();
    }

    protected void waitUntilWindowsCount(int windowsCount){
        wait.until(ExpectedConditions.numberOfWindowsToBe(windowsCount));
    }

    protected void switchToWindowByTitle(String windowTitle){
        Set<String> allWindowHandleIds = driver.getWindowHandles();

        for(String id : allWindowHandleIds){
            driver.switchTo().window(id);
            String currentTitle = driver.getTitle();
            if(currentTitle.equals(windowTitle)){
                break;
            }
        }
    }

    protected String getPageTitle(){
        return driver.getTitle();
    }

    protected String getElementAttribute(By by, String attributeName){
        return waitForElementVisibility(by).getAttribute(attributeName);
    }
}