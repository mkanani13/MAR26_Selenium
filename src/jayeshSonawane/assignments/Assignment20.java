package jayeshSonawane.assignments;

import jayeshSonawane.technocreditsFoodAppWithFrameworkPOM.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
    public void beforeMethod() {
        driver = BrowserActions.start("https://testing.qaautomationlabs.com/");
    }

    @Test
    public void iFrameDemoTC(){
        WebElement iFrameLinkText, iFrame1, iFrame1Button, iFrame2, iFrame2Button;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Wait for DashboardPage Load");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Tools Demo']")));
        System.out.println("Click on iFrame Link Text");
        iFrameLinkText = driver.findElement(By.linkText("iFrame"));
        Assert.assertEquals(iFrameLinkText.getText(), "iFrame");
        iFrameLinkText.click();

        System.out.println("Wait for IFrameDemoPage Load");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='IFrame']")));


//        Switch to iFrame
//        Method 1 = using Index
//        System.out.println("STEP - Switch to iFrame1 using Index");
//        driver.switchTo().frame(0); // First Image Index = 0
//        System.out.println("STEP - Click on Button inside iFrame1");
//        iFrame1Button = driver.findElement(By.xpath("//button[text()='CLick Me']"));
//        iFrame1Button.click();

//        Method 2 = using Name or Id
//        System.out.println("STEP - Switch to iFrame1 using Name");
//        driver.switchTo().frame("iframe1");
//        System.out.println("STEP - Click on Button inside iFrame1");
//        iFrame1Button = driver.findElement(By.xpath("//button[text()='CLick Me']"));
//        iFrame1Button.click();

//        Method 3 = using WebElement
        System.out.println("STEP - Switch to iFrame1 using WebElement");
        iFrame1 = driver.findElement(By.xpath("//iframe[@src='iframe1.php']"));
        driver.switchTo().frame(iFrame1);
        System.out.println("STEP - Click on Button inside iFrame1");
        iFrame1Button = driver.findElement(By.xpath("//button[text()='CLick Me']"));
        iFrame1Button.click();

        String expectedClickMessgae ="You have clicked on iframe 1 button";
        System.out.println("Come out of iFrame to main WebPage/DOM");
        driver.switchTo().defaultContent();
        String actualClickMessage = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualClickMessage, expectedClickMessgae);

        System.out.println("STEP - switch to iFrame2 using WebElement");
        iFrame2 = driver.findElement(By.xpath("//iframe[@src='iframe2.php']"));
        driver.switchTo().frame(iFrame2);
        System.out.println("STEP - Click on Button inside iFrame2");
        iFrame2Button = driver.findElement(By.xpath("//button[text()='Click Me']"));
        iFrame2Button.click();

        expectedClickMessgae ="You have clicked on iframe 2 button";
        System.out.println("Come out of iFrame to main WebPage/DOM");
        driver.switchTo().defaultContent();
        actualClickMessage = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(actualClickMessage, expectedClickMessgae);
    }

    @AfterMethod
    public void afterMethod(){
        BrowserActions.close();
    }
}
