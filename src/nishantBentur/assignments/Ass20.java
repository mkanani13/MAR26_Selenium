package nishantBentur.assignments;

import nishantBentur.base.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ass20 extends BrowserActions{

    @BeforeTest
    public void setup(){
        BrowserActions.start("https://testing.qaautomationlabs.com/");
    }

    @Test
    public void iFrameDemo(){
        System.out.println("STEP- Wait until the Page loads & Click on the iFrame button");
        WebElement iFrameBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='iFrame']")));
        iFrameBtn.click();

        System.out.println("STEP- Switch to Iframe1");
        driver.switchTo().frame("iframe1");

        System.out.println("STEP- Click on 'CLick Me' button");
        driver.findElement(By.xpath("//button[text()='CLick Me']")).click();

        System.out.println("STEP- Switch back to Main page");
        driver.switchTo().defaultContent();

        System.out.println("VERIFY MESSAGE- You have clicked on iframe1 button");
        boolean f1_message = driver.findElement(By.xpath("//p[text()='You have clicked on iframe 1 button']")).isDisplayed();
        Assert.assertTrue(f1_message);

        System.out.println("STEP- Switch to Iframe2");
        WebElement iFrame2Element = driver.findElement(By.xpath("(//iframe[1])[2]"));
        driver.switchTo().frame(iFrame2Element);

        System.out.println("STEP- Click on 'Click Me' button");
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        System.out.println("STEP- Switch back to Main page");
        driver.switchTo().parentFrame();

        System.out.println("VERIFY MESSAGE- You have clicked on iframe2 button");
        boolean f2_message = driver.findElement(By.xpath("//p[text()='You have clicked on iframe 2 button']")).isDisplayed();
        Assert.assertTrue(f2_message);
    }

    @AfterTest
    public void tearDown(){
        BrowserActions.closeBrowser();
    }
}
