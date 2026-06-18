/*
Write a Selenium WebDriver automation script in Java to perform the following steps:


1. Launch the application: http://automationbykrishna.com/
2. Click on the “Basic Elements” tab.
3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
5. Read the text message that appears.
6. Verify that the confirmation message displayed on the page is:

        "Hello NAME! How are you today?"

 */
package AutomationScript.Basics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {
     public static void main(String[] args) throws InterruptedException {
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         System.out.println("getting string url and clicking to required text");
         driver.get("http://automationbykrishna.com/");
         driver.findElement(By.linkText("Basic Elements")).click();
         Thread.sleep(2000);
         System.out.println("Finding javaScript prompt button ");
         WebElement  Alerttag =driver.findElement(By.xpath("//button[@id= 'javascriptPromp']"));
         System.out.println("Scrolling the element");
         JavascriptExecutor js = (JavascriptExecutor)driver;
         js.executeScript("arguments[0].scrollIntoView(true);",Alerttag);
         Alerttag.click();
         System.out.println("Clicked the element");
        Alert alert =  driver.switchTo().alert();
        alert.sendKeys("Amit");
         System.out.println("Given the name Amit");
        alert.accept();
        String  Pressbuttton = driver.findElement(By.xpath("//p[@id= 'pgraphdemo']")).getText();
        if (Pressbuttton.contains("Amit")){
            System.out.println("this is a success");
            System.out.println(Pressbuttton);
        }else
            System.out.println("You have cancled");

}
}



