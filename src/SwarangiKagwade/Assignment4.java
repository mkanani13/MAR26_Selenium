package SwarangiKagwade;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.

Alert message should pop-up "You must be TechnoCredits student!!"
*/
public class Assignment4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
    Thread.sleep(2000);

        WebElement element=driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();
        String alertMessage=alert.getText();
        if(alertMessage.equals("You must be TechnoCredits student!!")){
            System.out.println("Alert Mesasge varified ");
        }
        else
            System.out.println("Alert message Unvarified ");

        alert.accept();



    }
}
