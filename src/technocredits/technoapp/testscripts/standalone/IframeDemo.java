package technocredits.technoapp.testscripts.standalone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import technocredits.technoapp.base.BrowserActions;

import java.time.Duration;

public class IframeDemo {
    WebDriver driver;
    @BeforeMethod
    void setup(){
        driver = BrowserActions.start("https://testing.qaautomationlabs.com");
    }

    @Test
    public void frameElementTest(){
        System.out.println("STEP - navigate to Iframe menu");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='iFrame']"))).click();

        System.out.println("VERIFY - Frame section title should be IFrame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")));
        String pText = driver.findElement(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")).getText();
        System.out.println(pText);
        Assert.assertEquals(pText, "IFrame");

        System.out.println("Switch to Iframe");
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='iframe1.php']"));
        driver.switchTo().frame(frameElement);

        System.out.println("STEP - Click on click me button");
        driver.findElement(By.xpath("//button[text()='CLick Me']")).click();

        driver.switchTo().defaultContent();

        System.out.println("STEP - Get the message text");
        String text =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))).getText();
        System.out.println(text);
    }
}
