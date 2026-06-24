package jayeshSonawane.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import technocredits.customexception.BrowserInvalidException;

import java.time.Duration;
import java.util.Locale;

public class BrowserActions {

    protected static WebDriver driver = null;

    public static WebDriver start(){
        return start("chrome", "http://automationbykrishna.com/");
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

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Removed implicit wait. Use explicit wait wherever possible.
        return driver;
    }

    public static void close(){
        driver.quit();
    }
}
