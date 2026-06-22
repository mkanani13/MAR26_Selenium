// Selenium Assignment - 6: 10th June'2026
//Write a Selenium WebDriver automation script in Java to perform the following steps:
//1. Launch the application: http://automationbykrishna.com/
//2. Click on the “Basic Elements” tab.
//3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
//4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
//5. Read the text message that appears.
//6. Verify that the confirmation message displayed on the page is:
//        "Hello NAME! How are you today?"


package vipinSharma;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ass6_BEJavascriptPrompt {
    WebDriver driver;
    Alert alert;

    @BeforeTest
    public void setUp() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    public void javascriptPromptWithOK() throws InterruptedException {
        System.out.println("STEP - JavascriptPrompt button click");
        driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
        System.out.println("STEP- Name fill in prompt and Ok button click");
        alert = driver.switchTo().alert();
        alert.sendKeys("Vipin Sharma");
        alert.accept();
        Thread.sleep(1000);
        WebElement elementText = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementText);
        Thread.sleep(1000);

        String actualText = elementText.getText();
        String expectedText = "Hello Vipin Sharma! How are you today?";
        Assert.assertEquals(actualText, expectedText, "Alert message did not match!");
    }

    @Test
    public void javascriptPromptWithCanle() throws InterruptedException {
        System.out.println("STEP - JavascriptPrompt button click");
        driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(1000);
        WebElement elementText = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementText);
        Thread.sleep(1000);

        String actualText = elementText.getText();
        String expectedText = "User cancelled the prompt.";
        Assert.assertEquals(actualText, expectedText, "Alert message did not match!");
    }
}
