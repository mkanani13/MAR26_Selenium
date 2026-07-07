package smratiGarg.refactorRestaurentApp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.customexception.BrowserInvalidException;

import java.time.Duration;

public class BrowserActions {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;
    protected static Actions actions;
	public static WebDriver start() {
		return start("CHROME", "http://34.66.197.232/#/access");
	}
	
	public static WebDriver start(String url) {
		return start("CHROME", url);
	}
	
	public static WebDriver start(String browser, String url) {
		System.out.println("STEP - Launch browser & hit url");

        driver = switch (browser.toUpperCase()) {
            case "CHROME" -> new ChromeDriver();
            case "EDGE" -> new EdgeDriver();
            default -> throw new BrowserInvalidException("Given browser not supported");
        };

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        driver.manage().window().maximize();
		driver.get(url);

        actions = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		return driver; 
	}
}
