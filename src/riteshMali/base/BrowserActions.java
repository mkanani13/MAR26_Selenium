package riteshMali.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import riteshMali.utility.PropertyOperations;
import technocredits.customexception.BrowserInvalidException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserActions {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;
    protected static Actions actions;
    PropertyOperations configProperty = new PropertyOperations("src/riteshMali/config/config.properties");


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


    protected List<WebElement> waitForAllElementsVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected void tearDown(ITestResult result) {
        System.out.println("Method Name : " + result.getMethod().getMethodName());
        System.out.println("Test Execution start : " + result.getStartMillis());
        System.out.println("Test Execution End : " + result.getEndMillis());
        if (result.isSuccess()) {
            System.out.println("Test Executed successfully");
        } else {
            System.out.println("Test Execution failed");
        }

        System.out.println("Execution Done...!");
        driver.quit();
    }

    protected void setTextOnElement(By by, String enterText) {
        WebElement element = waitForElementVisibility(by);
        if (element.isEnabled()) {
            element.sendKeys(enterText);
        } else {
            throw new ElementNotInteractableException("Element is not interactable");
        }
    }

    protected void clickOnElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void clickOnElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    protected List<String> getAllTextOption(By by) {
        Select select = new Select(waitForElementVisibility(by));
        List<WebElement> listOfWebelements = select.getOptions();
        List<String> options = new ArrayList<>();
        for (WebElement element : listOfWebelements) {
            options.add(element.getText());
        }

        return options;
    }

    protected List<WebElement> getAllElements(By by) {
        return waitForAllElementsVisibility(by);
    }


    protected String getTextFromElement(By by) {
        return waitForElementVisibility(by).getText().trim();
    }

    protected void setLocationByVisibleText(By by, String dropdownVisibleText) {
        Select locationSelect = new Select(waitForElementVisibility(by));
        locationSelect.selectByVisibleText(dropdownVisibleText);
    }

    protected WebElement getElement(By by) {
        return waitForElementVisibility(by);
    }

    protected boolean isElementDisplayed(By by) {
        try {
            return waitForElementVisibility(by).isDisplayed();
        } catch (NoSuchElementException ne) {
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
        } catch (NoSuchElementException ne) {
            return false;
        }
    }

    protected void waitForElementTOBe(By by, int num) {
        waitForElementTOBe(by, num);
    }

    protected void markCheckbox(WebElement element) {
        if (element.isEnabled()) {
            element.click();
        } else {
            throw new ElementNotInteractableException("Element is not interactable");
        }
    }


}
