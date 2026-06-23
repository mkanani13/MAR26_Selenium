/*
Write a Selenium WebDriver automation script in Java to perform the following steps:


1. Launch the application: http://automationbykrishna.com/
2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
4. Handle the JavaScript confirmation alert that appears.
5. Read the alert message and accept it by clicking “OK”.
6. Verify that the confirmation message displayed on the page is:

       "You pressed OK!"

 */

package AutomationScript.Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("http://automationbykrishna.com/");
         driver.findElement(By.id("basicelements")).click();
        WebElement altbutton= driver.findElement(By.xpath("//button[@id= 'javascriptAlert']"));
         System.out.println(altbutton);
         JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].scrollIntoView(true);",altbutton);
         altbutton.click();
         Thread.sleep(2000);
         System.out.println("check the expectation");

// Switch to the JavaScript Alert
         Alert alert = driver.switchTo().alert();

// Get the text FROM the alert (not from the button element)
         String actual = alert.getText();
         System.out.println("Alert text: " + actual);

// Accept (close) the alert
         alert.accept();

         String expectedText = "You must be TechnoCredits student!!";

         if (actual.equals(expectedText)) {
             System.out.println("the required result is there");
         } else {
             System.out.println("failed");
         }




    }
}
