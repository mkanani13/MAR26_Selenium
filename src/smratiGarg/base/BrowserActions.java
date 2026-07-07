package smratiGarg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import technocredits.customexception.BrowserInvalidException;

import java.time.Duration;

public class  BrowserActions {
    protected static WebDriver driver = null;
	public static WebDriver start() {
		return start("CHROME", "http://automationbykrishna.com");
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

		return driver; 
	}
}
