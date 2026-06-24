package technocredits.technoapp.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.customexception.BrowserInvalidException;

public class BrowserActions {
    protected static WebDriver driver = null;
    protected static WebDriverWait wait;

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
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver; 
	}

    public static void quitBrowser(){

        driver.close();
    }
}
