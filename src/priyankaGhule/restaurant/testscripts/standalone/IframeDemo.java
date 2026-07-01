package priyankaGhule.restaurant.testscripts.standalone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import priyankaGhule.restaurant.base.BrowserActions;

import java.time.Duration;

public class IframeDemo {
    WebDriver driver;
    @BeforeMethod
    void setup(){
        driver = BrowserActions.start("https://testing.qaautomationlabs.com");
    }
    @Test
    public void frameElementTest(){
        System.out.println("STEP-Navigate to iframe menu");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Iframe']/parent::a"))).click();


        System.out.println("STEP-frame section title should be iframe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")));
        String pText = driver.findElement(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")).getText();
        System.out.println(pText);
        Assert.assertEquals(pText,"IFrame");

        System.out.println("Switch to Iframe");
        driver.switchTo().frame(0);

        System.out.println("SRTEP-click on ckick me button");
        driver.findElement(By.xpath("//button[text()='CLick Me']")).click();

        System.out.println("Back to main page");
        driver.switchTo().defaultContent();

        System.out.println("STEP-get the text msg");
        String text = driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println(text);

        System.out.println("Switch to 2nd frame");
        driver.switchTo().frame("iframe2");

        System.out.println("click on click me button");
        driver.findElement(By.xpath("//button[@class='btn btn-danger btn-sm w-100']")).click();

        System.out.println("Back to main page");
        driver.switchTo().defaultContent();

        System.out.println("STEP-get the text msg");
        String frametext = driver.findElement(By.xpath("//p[@id='message']")).getText();
        System.out.println(frametext);



    }

}
