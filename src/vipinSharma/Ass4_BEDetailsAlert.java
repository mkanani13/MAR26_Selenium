// Selenium Assignment - 4: 9th June'2026

//Automate the following scenario using Selenium WebDriver in Java:
//Open the application: http://automationbykrishna.com/
//Click on the “Basic Elements” tab/button.
//Click on the “Alert” tab/button present under DIFFERENT EXAMPLES OF ALERTS.
//Alert message should pop-up "You must be TechnoCredits student!!"


package vipinSharma;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass4_BEDetailsAlert {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        System.out.println("STEP - URL Navigation");
        driver.get("http://automationbykrishna.com/");
        System.out.println("STEP - Page Verification after redirect");
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Login Signup Demo";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
        System.out.println("STEP - Basic Elements link click");
        driver.findElement(By.id("basicelements")).click();

    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }


    @Test
    public void javaScriptAlertCheck() throws InterruptedException {
        System.out.println("STEP - Javascript alert button click");
        Thread.sleep(1000);
        WebElement javascriptAlert = driver.findElement(By.id("javascriptAlert"));
        System.out.println("STEP - Element Scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", javascriptAlert);
        javascriptAlert.click();
        Thread.sleep(1000);
        System.out.println("STEP - Verification of alert message");
        Alert alert = driver.switchTo().alert();
        String alertActualText= alert.getText();
        String expectedActualText= "You must be TechnoCredits student!!";
        Assert.assertEquals(alertActualText, expectedActualText, "Alert message did not match!");
        System.out.println("STEP - Alert Ok button click");
        alert.accept();
    }
}