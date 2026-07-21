package technocredits.technoapp.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.customexception.BrowserInvalidException;

public class BrowserActions {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public static WebDriver start() {
		return start("CHROME", "http://automationbykrishna.com");
	}
	
	public static WebDriver start(String url) {
		return start("CHROME", url);
	}
	
	public static WebDriver start(String browser, String url) {
		System.out.println("STEP - Launch browser & hit url");
		switch(browser.toUpperCase()) {
		 case "CHROME" :
			 driver = new ChromeDriver();
			 break;
			 
		 case "EDGE" : 
			 driver = new EdgeDriver();
			 break;
			 
		default : 
			throw new BrowserInvalidException("Given browser not supported");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver; 
	}

    private WebElement getElement(By by, boolean isWaitRequired){
        if(isWaitRequired)
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    protected void clickOnElement(WebElement e, boolean isWaitRequired){
        if(isWaitRequired)
            wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }

    protected void clickOnElement(By by, boolean isWaitRequired){
        WebElement e = getElement(by,isWaitRequired);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();

    }

    protected void setText(WebElement e, String text, boolean isWaitRequired){
        if(isWaitRequired)
            wait.until(ExpectedConditions.visibilityOf(e));
        e.sendKeys(text);
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

    protected void waitForNumberOfElementsToBeMoreThan(By by, int num){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,num));
    }

    public static void quitBrowser(){
        driver.close();
    }


}
