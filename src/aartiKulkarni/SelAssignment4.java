package aartiKulkarni;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Automate the following scenario using Selenium WebDriver in Java:

Open the application: http://automationbykrishna.com/
Click on the “Basic Elements” tab/button.

Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.

Alert message should pop-up "You must be TechnoCredits student!!

 */
public class SelAssignment4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        WebElement element=driver.findElement(By.xpath("//button[@id='javascriptAlert']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        Alert alert=driver.switchTo().alert();
        String actualMessage=alert.getText();
        if(actualMessage.equals("You must be TechnoCredits student!!"))
            System.out.println("test case -passed ");
        else
            System.out.println("Test case -failed ");


    }
}
