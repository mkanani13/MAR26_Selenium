package rajashreePatil.Base;

import rajashreePatil.CustomeException.BrowserInvalidException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserActions {
    public static WebDriver start(){
        System.out.println("Calling below overloaded start method to avoid code duplication");
         return start("CHROME", "http://automationbykrishna.com/");
        // return start("CHROME", "http://34.173.201.53/#/login");
    }
    public static WebDriver start(String url){
        System.out.println("Calling below overloaded start method to avoid code duplication");
        return start("CHROME", url);

    }
    public static WebDriver start(String browser, String url){
        System.out.println("STEP - Launch browser and hit URL");
        WebDriver driver = null;
        switch(browser.toUpperCase()){
            case "CHROME":
                driver = new ChromeDriver();
                break;

            case "EDGE":
                driver = new EdgeDriver();
                break;
            default :
                throw new BrowserInvalidException("Given browser is not supported");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
