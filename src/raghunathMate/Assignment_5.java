package raghunathMate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment_5 {
    @Test
    void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://automationbykrishna.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='basicelements']")).click();
        Thread.sleep(1000);
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",confirmAlertButton);
        confirmAlertButton.click();
        Thread.sleep(1000);
        String msgWithOk = "You pressed OK!";
        String msgWithCancel = "You pressed Cancel!";
        Alert alt = driver.switchTo().alert();
        alt.accept();
        String actualmsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertEquals(msgWithOk,actualmsg);
        Thread.sleep(3000);
        confirmAlertButton.click();
        Thread.sleep(1000);
       // Alert alt1 = driver.switchTo().alert();
        alt.dismiss();
         actualmsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
        Assert.assertEquals(msgWithCancel,actualmsg);
        Thread.sleep(1000);
        driver.quit();
    }
}
