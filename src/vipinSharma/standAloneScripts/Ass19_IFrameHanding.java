package vipinSharma.standAloneScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ass19_IFrameHanding {
    WebDriver driver;

    @BeforeTest
    public void browserLaunch() {
        System.out.println("STEP - WebDriver Initializing and Browser Launched");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void setupEnd() {
        driver.quit();
        System.out.println("Browser closed");
    }

    public void navigationSteps() {
        System.out.println("STEP - URL Navigation");
        driver.get("https://testing.qaautomationlabs.com/iframe.php");
        System.out.println("STEP - Page Verification after redirect");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='IFrame Demo']")));
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "IFrame Demo | QA Automation Labs";
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title not match!");
    }

    @Test
    public void verifyIFrame(){
        navigationSteps();
        System.out.println("STEP - Switch to the 'I am iFrame1' frame");
        driver.switchTo().frame(0);

        System.out.println("STEP - Click the 'Click Me' button inside iFrame1");
        WebElement clickMeButton1= driver.findElement(By.xpath("//Button[text()='CLick Me']"));
        clickMeButton1.click();

        System.out.println("STEP - Switch back to the main web page (default content)");
        driver.switchTo().defaultContent();

        System.out.println("STEP - Verify that the message 'You have clicked on iframe1 button' is displayed");
        String actualMessageText= driver.findElement(By.id("message")).getText();
        String expectedMessageText ="You have clicked on iframe 1 button";
        Assert.assertEquals(actualMessageText, expectedMessageText, "Message text not match!");


        System.out.println("STEP - Switch to the 'I am iFrame2' frame");
        driver.switchTo().frame("iframe2");

        System.out.println("STEP - Click the 'Click Me' button inside iFrame2");
        WebElement clickMeButton2= driver.findElement(By.xpath("//Button[text()='Click Me']"));
        clickMeButton2.click();

        System.out.println("STEP - Switch back to the main web page (default content)");
        driver.switchTo().defaultContent();

        System.out.println("STEP - Verify that the message 'You have clicked on iframe2 button' is displayed");
        String actualMessageTxt= driver.findElement(By.id("message")).getText();
        String expectedMessageTxt ="You have clicked on iframe 2 button";
        Assert.assertEquals(expectedMessageTxt, actualMessageTxt, "Message text not match!");

    }
}
