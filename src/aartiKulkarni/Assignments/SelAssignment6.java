package aartiKulkarni.Assignments;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
public class SelAssignment6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationbykrishna.com/");
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        WebElement element=driver.findElement(By.xpath("//button[@id='javascriptPromp']"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        Alert alert=driver.switchTo().alert();
        String name="Aarti";
        alert.sendKeys(name);
        alert.accept();
        Thread.sleep(1000);
        String actualMessage=driver.findElement(By.id("pgraphdemo")).getText();
        String expectedMessage = ("Hello " + name + "! How are you today?");
        Thread.sleep(1000);

        System.out.println(actualMessage);

        if(actualMessage.equals(expectedMessage)) {
            System.out.println("Test case -passed");
        }
        else {
            System.out.println("Test case Filed ");
        }
        Thread.sleep(2000);
        driver.quit();

    }
}
