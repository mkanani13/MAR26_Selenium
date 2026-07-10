package aartiKulkarni.Assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
public class SelAssignment5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        WebElement element=driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);" , element);
        element.click();

        Alert alert=driver.switchTo().alert();
        String actualMessage=alert.getText();
        Thread.sleep(1000);
        alert.accept();

        if(actualMessage.equals( "You pressed OK!")) {
            System.out.println("Test case passed");
            alert.sendKeys("You pressed ok!!");
        }
        else {
            System.out.println("Test case failed ");
            alert.sendKeys("You pressed cancel !!");
        }
        Thread.sleep(2000);
        driver.quit();



    }


}
