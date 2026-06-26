/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.

Alert message should pop-up "You must be TechnoCredits student!!"


 */

package Amitjoshi.Assignments.Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
    public  static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("basicelements")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//button[@id= 'javascriptAlert']")).click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String ExpectedText= "You must be TechnoCredits student!!";

        if(actualText.equals(ExpectedText)){
            System.out.println("success");
        }else{
            System.out.println("failed");
        }
        alert.accept();
        driver.quit();


    }
}
