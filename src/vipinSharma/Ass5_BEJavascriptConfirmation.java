// Selenium Assignment - 5: 10th June'2026
//Write a Selenium WebDriver automation script in Java to perform the following steps:
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Confirmation” tab/button.
//4. Handle the JavaScript confirmation alert that appears.
//5. Read the alert message and accept it by clicking “OK”.
//6. Verify that the confirmation message displayed on the page is:
//       "You pressed OK!"


package automationScritps;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass5_BEJavascriptConfirmation {
    WebDriver driver;
    Alert alert;
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

    public void alertPopupHandel() throws InterruptedException {
        System.out.println("STEP - Javascript Confirmation button click");
        WebElement javascriptConfirmBox = driver.findElement(By.id("javascriptConfirmBox"));
        System.out.println("STEP - Element Scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", javascriptConfirmBox);
        javascriptConfirmBox.click();
        Thread.sleep(1000);
        alert = driver.switchTo().alert();
        String actualAlertTxt = alert.getText();
        String expectedAlertTxt = "Are you are doing your homework regularly, Press Okay else Cancel!!";
        Assert.assertEquals(actualAlertTxt, expectedAlertTxt, "Alert message did not match!");
    }

    @Test
    public void textVerificationWithAlertCancle() throws InterruptedException {
        alertPopupHandel();
        System.out.println("STEP - Alert Ok button click");
        alert.dismiss();
        Thread.sleep(1000);
        WebElement elementText = driver.findElement(By.id("pgraphdemo"));
        System.out.println("STEP - Element Scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementText);
        Thread.sleep(1000);
        System.out.println("STEP - Verification of alert message");
        String actualTextOkButtonPress = elementText.getText();
        String expectedTextOkButtonPress = "You pressed Cancel!";
        Assert.assertEquals(actualTextOkButtonPress, expectedTextOkButtonPress, "Message text did not match!");
    }


    @Test
    public void textVerificationWithAlertOK() throws InterruptedException {
        alertPopupHandel();
        System.out.println("STEP - Alert Ok button click");
        alert.accept();
        Thread.sleep(1000);
        WebElement elementText = driver.findElement(By.id("pgraphdemo"));
        System.out.println("STEP - Element Scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementText);
        Thread.sleep(1000);
        System.out.println("STEP - Verification of alert message");
        String actualTextOkButtonPress = elementText.getText();
        String expectedTextOkButtonPress = "You pressed OK!";
        Assert.assertEquals(actualTextOkButtonPress, expectedTextOkButtonPress, "Message text did not match!");
    }
}