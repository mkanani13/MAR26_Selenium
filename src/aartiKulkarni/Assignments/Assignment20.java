package aartiKulkarni.Assignments;

import aartiKulkarni.technoApp.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
Using Selenium WebDriver with Java, automate the following end-to-end food ordering scenario
(Use Explicit Wait instead of Implicit Wait) with a Standalone Script:

1.Launch the browser and navigate to:
https://testing.qaautomationlabs.com/iframe.php
2.Switch to the "I am iFrame1" frame.
3.Click the "Click Me" button inside iFrame1.
4.Verify that the message "You have clicked on iframe1 button" is displayed.
5.Switch back to the main web page (default content).
6.Switch to the "I am iFrame2" frame.
7.Click the "Click Me" button inside iFrame2.
8.Verify that the message "You have clicked on iframe2 button" is displayed.
9.Close the browser after successful execution.

 */
public class Assignment20 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= BrowserActions.start("https://testing.qaautomationlabs.com");
    }
    @Test
    public void iFrameAutomationDemo(){
        System.out.println("STEP - navigate to Iframe menu");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Iframe']"))).click();

        System.out.println("Frame title should be Iframe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")));
        String pText=driver.findElement(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")).getText();
        System.out.println(pText);
        Assert.assertEquals(pText,"IFrame");

        System.out.println("Switch to Iframe");
        WebElement frameElement= driver.findElement(By.xpath("//iframe[@src='iframe1.php']"));
        driver.switchTo().frame(frameElement);

        System.out.println("Click the Click Me button inside iFrame1.");
        driver.findElement(By.xpath("//button[text()='CLick Me']")).click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

        System.out.println("Switch to main page ");
        driver.switchTo().defaultContent();

        System.out.println("Get Text");
        String text=driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println(text);



        System.out.println("Switch to the I am iFrame2frame.");
        WebElement frameElement2=driver.findElement(By.xpath("//iframe[@src='iframe2.php']"));
        driver.switchTo().frame(frameElement2);

        System.out.println("Click the Click Me button inside iFrame2");
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        System.out.println("switch to main page ");
        driver.switchTo().defaultContent();

        String text1=driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println(text1);

        driver.quit();

    }

}
