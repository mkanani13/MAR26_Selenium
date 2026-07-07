package vishwajeetLoni.base;

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
        return driver;
    }

    public static void quitBrowser(){
        driver.close();
    }

}
