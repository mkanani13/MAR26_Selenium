package automationScript;

//Automate the following scenario using Selenium WebDriver in Java:
//
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//
//Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.
//
//Alert message should pop-up "You must be TechnoCredits student!!"


import CustomeException.BrowserInvalid;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Locale;

public class Assignment4 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", alertBtn);

        alertBtn.click();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();

        String alertActualMessage = alert.getText();

        if(alertActualMessage.equals("You must be TechnoCredits student!!")){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

        driver.quit();
    }


    public static class BrowserAction{

       public static WebDriver start(){
           return start("chrome" ,"http://automationbykrishna.com" );
       }



       public static WebDriver  start(String browser , String url){
           System.out.println("Step - launch Browser & hit url");
           WebDriver driver = null;

           switch (browser.toUpperCase(Locale.ROOT)){
               case "CHROME":
                   driver = new ChromeDriver();
                   break;
               case "EDGE":
                   driver = new EdgeDriver();
                   break;
               default:
                   throw new BrowserInvalid("Given Browser not supported");
           }
           driver.get(url);
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

           return driver;
        }
    }
}
