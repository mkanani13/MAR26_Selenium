package RadhikaA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {


        public static void main (String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("STEP - Navigation to automationbykrishna");
            driver.get("http://automationbykrishna.com/");
        }
}
