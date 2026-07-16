package smratiGarg.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Asgn20_iframe {
    @Test
    public void BrowserOpen () throws InterruptedException {

        System.out.println("STEP - Open Browser and hit URL");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testing.qaautomationlabs.com");

        System.out.println("navigate and click to iframe");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Iframe']/parent::a"))).click();

        System.out.println("Verify-Frame section title should be IFrame");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")));
        String pTaxt = driver.findElement(By.xpath("//p[@class='text-light mb-1 mt-1 ml-1']")).getText();
        System.out.println(pTaxt);
        Assert.assertEquals(pTaxt, "IFrame");

        System.out.println("switch to frame");
        driver.switchTo().frame(0);

        System.out.println("STEP click on click button");
        driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

        driver.switchTo().parentFrame();
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))).getText();
        System.out.println(text);
        Assert.assertEquals(text, "You have clicked on iframe 1 button");



    }
}
