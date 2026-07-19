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
package Amitjoshi.Assignments.Basics;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment6 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://automationbykrishna.com/");
    }

    @Test
    public void verifyJavaScriptPromptMessage() {
        String name = "Amit";
        driver.findElement(By.id("basicelements")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("javascriptPromp"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(name);
        alert.accept();

        String promptMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pgraphdemo"))).getText();
        Assert.assertEquals(promptMessage, "Hello " + name + "! How are you today?");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}