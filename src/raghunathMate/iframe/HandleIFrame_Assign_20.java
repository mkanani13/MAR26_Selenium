package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.BrowserAction;

import java.time.Duration;

public class HandleIFrame_Assign_20 extends BrowserAction {
    @BeforeMethod
    public void setUp() {
        System.out.println("Step-1.Launch the browser and navigate to:https://testing.qaautomationlabs.com/iframe.php ");
        BrowserAction.start("https://testing.qaautomationlabs.com/iframe.php");
    }

    @Test
    public void handleIFrame_Ass_20() throws InterruptedException {

        System.out.println("Step - 2.Switch to the I am iFrame1 frame.");
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@src='iframe1.php']")));
        driver.switchTo().frame("iframe1");
        System.out.println("Step - 3.Click the Click Me button inside iFrame1.");
        driver.findElement(By.xpath("//button[text()='CLick Me']")).click();
       // Thread.sleep(2000);
        System.out.println("Step - 4.Verify that the message You have clicked on iframe1 button is displayed.");
        driver.switchTo().defaultContent();
        WebElement msg1 = driver.findElement(By.xpath("//p[text()='You have clicked on iframe 1 button']"));
        boolean msgFlag1 = msg1.isDisplayed();
        Assert.assertTrue(msgFlag1);
        System.out.println("Step - 6.Switch to the I am iFrame2 frame.");
        driver.switchTo().frame("iframe2");
        System.out.println("Step - 7.Click the Click Me button inside iFrame2.");
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
        driver.switchTo().defaultContent();
        System.out.println("Step - 8.Verify that the message You have clicked on iframe2 button is displayed.");
        WebElement msg2 = driver.findElement(By.xpath("//p[text()='You have clicked on iframe 2 button']"));
        boolean msgFlag2 = msg2.isDisplayed();
        Assert.assertTrue(msgFlag2);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}