package jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.customExceptions.BrowserInvalidException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void visibilityOfElementLocated(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static String visibilityOfElementLocatedText(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

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
            FileUtils.copyFile(srcFile, new File("src/jayeshSonawane/technocreditsFoodAppWithFrameworkPOM/screenshots/"+fileName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(){
        driver.quit();
    }
}
