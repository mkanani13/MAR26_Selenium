/*Selenium Assignment - 6: 10th June'2026
        Write a Selenium WebDriver automation script in Java to perform the following steps:


        1. Launch the application: http://automationbykrishna.com/
        2. Click on the “Basic Elements” tab.
        3. Under the section “DIFFERENT EXAMPLES OF ALERTS”, click on the “Javascript Prompt” tab/button.
        4. Enter the NAME in the JavaScript Prompt that appears and click on "OK" button.
        5. Read the text message that appears.
        6. Verify that the confirmation message displayed on the page is:

        "Hello NAME! How are you today?"*/

package rajashreePatil.automationScript;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment6 {
    public void enterTextInAlertOnBasicElementsPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationbykrishna.com/");

        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",alertBtn);
        alertBtn.click();

        Thread.sleep(1000);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys("Rajashree");

        String actualAlertText = alert.getText();
        Thread.sleep(1000);
        alert.accept();
        String expectedTextAfterAlertAction = "Hello Rajashree! How are you today?";
        Thread.sleep(1000);
        WebElement actualTextAfterAlert = driver.findElement(By.xpath("//p[@id='pgraphdemo']"));
        String actualTextAfterAlertAction= actualTextAfterAlert.getText();
        System.out.println("Expected: " +expectedTextAfterAlertAction);
        System.out.println("Actual: " +actualTextAfterAlertAction);

        Assert.assertEquals(actualTextAfterAlertAction,expectedTextAfterAlertAction);
        driver.quit();

    }
    @Test
    public void verifyAlertText() throws InterruptedException {
        Assignment6 assignment6 = new Assignment6();
        assignment6.enterTextInAlertOnBasicElementsPage();
    }
}
