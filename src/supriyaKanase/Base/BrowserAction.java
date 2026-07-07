package supriyaKanase.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserAction {
    protected static WebDriver driver = null;

    public static WebDriver start( String url){

        return start("CHROME", url);
    }

    public static WebDriver start(String browser,String url){
        System.out.println("step - Launch Browser and Hit Url");

        switch (browser.toUpperCase()){
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case  "EDGE":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Given Browser not supported");
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

}
