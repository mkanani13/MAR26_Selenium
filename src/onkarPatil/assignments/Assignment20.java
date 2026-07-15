package onkarPatil.assignments;

import onkarPatil.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class Assignment20 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserActions.start("https://testing.qaautomationlabs.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void iFrameDemo(){
        System.out.println("STEP- Click on iFrame button");
        WebElement iFrameElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='iframe.php'][contains(@class,'btn')]")));
        iFrameElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='iframe1']")));

        System.out.println("STEP- Switch to first iFrame");
        driver.switchTo().frame("iframe1");
        WebElement iFrame1ClickMe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='CLick Me']")));
        iFrame1ClickMe.click();

        System.out.println("VERIFY- Verify the message by switching to main frame");
        driver.switchTo().parentFrame();
        String message = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(message, "You have clicked on iframe 1 button");

        System.out.println("STEP- Switch to second frame");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='iframe2.php']")));
        WebElement iFrame2ClickMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click Me']")));
        iFrame2ClickMe.click();

        System.out.println("VERIFY- Verify the message by switching to the parent frame");
        driver.switchTo().defaultContent();
        String message1 = driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(message1, "You have clicked on iframe 2 button");
    }

    @AfterMethod
    public void cleanup(){
        BrowserActions.quitBrowser();
    }
}
